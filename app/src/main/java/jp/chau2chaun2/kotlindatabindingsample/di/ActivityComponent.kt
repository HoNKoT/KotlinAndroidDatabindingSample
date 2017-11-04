package jp.chau2chaun2.kotlindatabindingsample.di

import dagger.Subcomponent
import jp.chau2chaun2.kotlindatabindingsample.view.BMIRealtimeCalculateActivity

@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: BMIRealtimeCalculateActivity)
}
