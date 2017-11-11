package jp.chau2chaun2.kotlindatabindingsample.di

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import com.github.gfx.android.orma.AccessThreadConstraint
import dagger.Module
import dagger.Provides
import jp.chau2chaun2.kotlindatabindingsample.model.orma.OrmaDatabase
import javax.inject.Singleton

@Module
class AppModule(private val mContext: Context) {

    @Provides
    internal fun provideContext(): Context {
        return mContext
    }

    @Provides
    internal fun provideLayoutInflater(context: Context): LayoutInflater {
        return LayoutInflater.from(context)
    }

    @Singleton
    @Provides
    internal fun provideSharedPreference(context: Context): SharedPreferences.Editor {
        return context.getSharedPreferences("Default", Context.MODE_PRIVATE).edit()
    }

    @Singleton
    @Provides
    internal fun providesOrmaDatabase(context: Context): OrmaDatabase {
        return OrmaDatabase.builder(context)
                .writeOnMainThread(AccessThreadConstraint.NONE)
                .readOnMainThread(AccessThreadConstraint.NONE)
                .build()
    }
}
