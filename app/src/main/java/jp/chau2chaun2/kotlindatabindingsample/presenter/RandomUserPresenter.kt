package jp.chau2chaun2.kotlindatabindingsample.presenter

import jp.chau2chaun2.kotlindatabindingsample.model.orma.RandomUser
import jp.chau2chaun2.kotlindatabindingsample.net.client.IApiRandomUser
import javax.inject.Inject

class RandomUserPresenter @Inject constructor(private val apiRandomUser: IApiRandomUser) {

    fun getNewRandomUser(): RandomUser? = apiRandomUser.getRandomUser()
}