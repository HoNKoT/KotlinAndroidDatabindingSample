package jp.chau2chaun2.kotlindatabindingsample.di

import android.app.Activity
import dagger.Module
import dagger.Provides
import jp.chau2chaun2.kotlindatabindingsample.model.Gender
import javax.inject.Named

@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    @Named(value = "F")
    fun provideGenderFemale(): Gender {
        return Gender.Female
    }

    @Provides
    @Named(value = "M")
    fun provideGenderMale(): Gender {
        return Gender.Male
    }
}
