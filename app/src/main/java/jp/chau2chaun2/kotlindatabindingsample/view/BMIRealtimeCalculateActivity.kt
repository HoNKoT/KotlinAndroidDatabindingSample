package jp.chau2chaun2.kotlindatabindingsample.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import jp.chau2chaun2.kotlindatabindingsample.R
import jp.chau2chaun2.kotlindatabindingsample.databinding.ActivityBmiRealtimeCalculateBinding
import jp.chau2chaun2.kotlindatabindingsample.model.Gender
import jp.chau2chaun2.kotlindatabindingsample.viewmodel.BMIRealtimeCalculateViewModel
import javax.inject.Inject
import javax.inject.Named

class BMIRealtimeCalculateActivity : BaseActivity() {

    private val mBinding: ActivityBmiRealtimeCalculateBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_bmi_realtime_calculate)
    }

    @Inject lateinit var viewModel: BMIRealtimeCalculateViewModel

    // NOTE: Use this instead of @Inject @Named(value = "F")
    @field:[Inject Named("F")] lateinit var gender: Gender

    override fun onActivityInject() {
        mComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("out", gender.toString())

        mBinding.viewModel = viewModel
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, BMIRealtimeCalculateActivity::class.java)
        }
    }
}