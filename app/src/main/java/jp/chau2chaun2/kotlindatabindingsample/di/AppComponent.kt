package jp.chau2chaun2.kotlindatabindingsample.di

import dagger.Component
import jp.chau2chaun2.kotlindatabindingsample.CustomApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class)
)
interface AppComponent {

    fun inject(customApplication: CustomApplication)

    fun plus(module: ActivityModule): ActivityComponent
}
