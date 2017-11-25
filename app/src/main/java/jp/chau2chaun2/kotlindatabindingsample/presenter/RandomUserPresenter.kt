package jp.chau2chaun2.kotlindatabindingsample.presenter

import android.content.Context
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jp.chau2chaun2.kotlindatabindingsample.dao.NameDao
import jp.chau2chaun2.kotlindatabindingsample.dao.ResultDao
import jp.chau2chaun2.kotlindatabindingsample.model.orma.RandomUser
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Result
import jp.chau2chaun2.kotlindatabindingsample.net.client.IApiRandomUser
import javax.inject.Inject

class RandomUserPresenter @Inject constructor(private val context: Context,
                                              private val apiRandomUser: IApiRandomUser,
                                              private val resultDao: ResultDao,
                                              private val nameDao: NameDao) {

    fun getCurrentUsers(): List<Result> = resultDao.relation.toList()

    fun getNewRandomUser(callback: () -> Unit) {
        apiRandomUser.getRandomUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ newRandomUser ->
                    // Successful
                    registeredRandomUser(newRandomUser)
                    callback()

                }, {
                    // Failed
                    Toast.makeText(context, "Sth Error occurred.", Toast.LENGTH_SHORT).show()
                })
    }

    fun getNewRandomUsers(numberOfUsers: Int, callback: () -> Unit) {
        apiRandomUser.getRandomUser(numberOfUsers)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ newRandomUser ->
                    // onNext
                    registeredRandomUser(newRandomUser)
                    callback()

                }, { e ->
                    // onError
                    Toast.makeText(context, "Sth Error occurred. ${e.message}", Toast.LENGTH_SHORT).show()
                }, {
                    // onComplete
                    // Nothing to do.
                })
    }

    private fun registeredRandomUser(randomUser: RandomUser) {
        nameDao.insert(randomUser)
        resultDao.insert(randomUser)
    }
}
