package jp.chau2chaun2.kotlindatabindingsample.di

import dagger.Component
import jp.chau2chaun2.kotlindatabindingsample.view.BMIRealtimeCalculateActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ModelModule::class)
)
interface AppComponent {
    fun inject(activity: BMIRealtimeCalculateActivity)
}
