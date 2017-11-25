package jp.chau2chaun2.kotlindatabindingsample.net.client

import android.accounts.NetworkErrorException
import io.reactivex.Observable
import io.reactivex.Single
import jp.chau2chaun2.kotlindatabindingsample.model.orma.RandomUser
import jp.chau2chaun2.kotlindatabindingsample.net.IApiService
import javax.inject.Inject

interface IApiRandomUser {
    fun getRandomUser(): Single<RandomUser>
    fun getRandomUser(numberOfUsers: Int): Observable<RandomUser>
}

class ApiRandomUserClient @Inject constructor(private val apiService: IApiService) : IApiRandomUser {

    override fun getRandomUser(): Single<RandomUser> {
        return Single.create { subscriber ->
            try {
                val responce = apiService.apiDemo().execute()

                responce.body()?.takeIf { responce.isSuccessful }?.let {
                    subscriber.onSuccess(it)
                } ?: run {
                    subscriber.onError(NetworkErrorException("Error occurred somehow."))
                }

            } catch (e: NetworkErrorException) {
                subscriber.onError(e)
            }
        }
    }

    override fun getRandomUser(numberOfUsers: Int): Observable<RandomUser> {
        return Observable.create { subscriber ->
            try {
                for (i in 0 until numberOfUsers) {
                    val responce = apiService.apiDemo().execute()

                    responce.body()?.takeIf { responce.isSuccessful }?.let {
                        subscriber.onNext(it)

                    } ?: run {
                        subscriber.onError(NetworkErrorException("Error occurred somehow."))
                        return@create
                    }
                }

                subscriber.onComplete()

            } catch (e: NetworkErrorException) {
                subscriber.onError(e)
            }
        }
    }
}
