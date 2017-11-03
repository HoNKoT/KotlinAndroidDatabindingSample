package jp.chau2chaun2.kotlindatabindingsample

import android.app.Application
import jp.chau2chaun2.kotlindatabindingsample.di.AppComponent
import jp.chau2chaun2.kotlindatabindingsample.di.AppModule
import jp.chau2chaun2.kotlindatabindingsample.di.DaggerAppComponent
import jp.chau2chaun2.kotlindatabindingsample.di.ModelModule

class CustomApplication : Application() {

    private lateinit var appComponent: AppComponent

    fun getComponent(): AppComponent {
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .modelModule(ModelModule())
                .build()
    }
}