package jp.chau2chaun2.kotlindatabindingsample.di

import dagger.Binds
import dagger.Module
import jp.chau2chaun2.kotlindatabindingsample.net.client.ApiRandomUserClient
import jp.chau2chaun2.kotlindatabindingsample.net.client.IApiRandomUser

@Module
interface ClientModule {
    @Binds fun bindApiService(client: ApiRandomUserClient): IApiRandomUser
}
