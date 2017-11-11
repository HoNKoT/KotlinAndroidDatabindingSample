package jp.chau2chaun2.kotlindatabindingsample

import android.app.Application
import android.content.SharedPreferences
import jp.chau2chaun2.kotlindatabindingsample.di.AppComponent
import jp.chau2chaun2.kotlindatabindingsample.di.AppModule
import jp.chau2chaun2.kotlindatabindingsample.di.DaggerAppComponent
import javax.inject.Inject

class CustomApplication : Application() {

    private lateinit var appComponent: AppComponent

    @Inject lateinit var preference: SharedPreferences.Editor

    fun getComponent(): AppComponent = appComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build().also { it.inject(this) }
    }
}