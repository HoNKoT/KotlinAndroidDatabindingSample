package jp.chau2chaun2.kotlindatabindingsample.di

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val mContext: Context) {

    @Provides
    fun provideContext(): Context {
        return mContext
    }

    @Provides
    fun provideLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(mContext)
    }

    @Singleton
    @Provides
    fun provideSharedPreference(): SharedPreferences.Editor {
        return mContext.getSharedPreferences("Default", Context.MODE_PRIVATE).edit()
    }

//    @Singleton
//    @Provides
//    fun providePersonPresenter(): PersonPresenter {
//        return PersonPresenter()
//    }
}
