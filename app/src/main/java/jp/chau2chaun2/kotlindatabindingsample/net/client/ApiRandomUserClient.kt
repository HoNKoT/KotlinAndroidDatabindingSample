package jp.chau2chaun2.kotlindatabindingsample.net.client

import android.accounts.NetworkErrorException
import jp.chau2chaun2.kotlindatabindingsample.model.orma.RandomUser
import jp.chau2chaun2.kotlindatabindingsample.net.IApiService
import javax.inject.Inject

interface IApiRandomUser {
    fun getRandomUser(): RandomUser?
}

class ApiRandomUserClient @Inject constructor(private val apiService: IApiService) : IApiRandomUser {
    override fun getRandomUser(): RandomUser? {
        try {
            val responce = apiService.apiDemo().execute()

            if (responce.isSuccessful) {
                return responce.body()
            } else {
                return null
            }

        } catch (e: NetworkErrorException) {

        }
        return null
    }
}