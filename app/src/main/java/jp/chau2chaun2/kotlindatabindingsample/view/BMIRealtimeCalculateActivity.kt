package jp.chau2chaun2.kotlindatabindingsample.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import jp.chau2chaun2.kotlindatabindingsample.R
import jp.chau2chaun2.kotlindatabindingsample.databinding.ActivityBmiRealtimeCalculateBinding
import jp.chau2chaun2.kotlindatabindingsample.di.AppComponent
import jp.chau2chaun2.kotlindatabindingsample.viewmodel.BMIRealtimeCalculateViewModel
import javax.inject.Inject

class BMIRealtimeCalculateActivity : BaseActivity() {

    private val mBinding: ActivityBmiRealtimeCalculateBinding by lazy {
        DataBindingUtil.setContentView<ActivityBmiRealtimeCalculateBinding>(this, R.layout.activity_bmi_realtime_calculate)
    }

    @Inject lateinit var viewModel: BMIRealtimeCalculateViewModel

    override fun onActivityInject() {
        mComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.viewModel = viewModel
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, BMIRealtimeCalculateActivity::class.java)
        }
    }
}