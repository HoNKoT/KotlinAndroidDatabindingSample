package jp.chau2chaun2.kotlindatabindingsample.di

import dagger.Module
import dagger.Provides
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter
import javax.inject.Singleton

@Module
class ModelModule {

    @Provides
    @Singleton
    fun providePersonPresenter(): PersonPresenter {
        return PersonPresenter()
    }
}
