package jp.chau2chaun2.kotlindatabindingsample.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jp.chau2chaun2.kotlindatabindingsample.R
import jp.chau2chaun2.kotlindatabindingsample.databinding.ActivityBmiCalculateBinding
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter
import jp.chau2chaun2.kotlindatabindingsample.task.BMICalculatorTask

class BMICalculateActivity : BaseActivity() {

    private val mBinding: ActivityBmiCalculateBinding by lazy {
        DataBindingUtil.setContentView<ActivityBmiCalculateBinding>(this, R.layout.activity_bmi_calculate)
    }

    private lateinit var mPerson: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding.person = mPerson
    }

    override fun onActivityInject() {
        mComponent.inject(this)
        mPerson = PersonPresenter.create
    }

    private fun updatePerson() {
        mBinding.person?.apply {
            height = mBinding.heightEditText.text.toString().takeIf { it.isNotEmpty() }?.toDouble()
            weight = mBinding.weightEditText.text.toString().takeIf { it.isNotEmpty() }?.toDouble()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickBmi(view: View) {
        updatePerson()

        if (mBinding.person?.canCalculate == true) {
            mBinding.task = BMICalculatorTask().also { it.execute(mBinding.person!!) }
        } else {
            Toast.makeText(this, "input height and weight first", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, BMICalculateActivity::class.java)
        }
    }
}
