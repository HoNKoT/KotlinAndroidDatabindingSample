package jp.chau2chaun2.kotlindatabindingsample.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.chau2chaun2.kotlindatabindingsample.CustomApplication
import jp.chau2chaun2.kotlindatabindingsample.di.ActivityComponent
import jp.chau2chaun2.kotlindatabindingsample.di.ActivityModule

abstract class BaseActivity : AppCompatActivity() {

    val mComponent: ActivityComponent get() = (application as CustomApplication).getComponent()
            .plus(ActivityModule(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActivityInject()
    }

    open fun onActivityInject() {
        // nothing to do
    }
}
