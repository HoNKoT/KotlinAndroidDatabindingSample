package jp.chau2chaun2.kotlindatabindingsample.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val mContext: Context) {

    @Provides
    fun provideContext(): Context {
        return mContext
    }
}
