package jp.chau2chaun2.kotlindatabindingsample.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import jp.chau2chaun2.kotlindatabindingsample.R
import jp.chau2chaun2.kotlindatabindingsample.databinding.ActivityBmiListBinding
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter
import javax.inject.Inject

class BMIListActivity : BaseActivity() {

    @Inject lateinit var personPresenter: PersonPresenter

    override fun onActivityInject() {
        mComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityBmiListBinding>(this, R.layout.activity_bmi_list).also {
            personPresenter.initializeIfNeeded()
            it.persons = personPresenter.getAllPerson()
        }
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, BMIListActivity::class.java)
    }
}
