package jp.chau2chaun2.kotlindatabindingsample.di

import android.app.Activity
import dagger.Module
import dagger.Provides
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter

@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return mActivity
    }

    @ActivityScope
    @Provides
    fun providePersonPresenter(): PersonPresenter {
        return PersonPresenter()
    }
}
