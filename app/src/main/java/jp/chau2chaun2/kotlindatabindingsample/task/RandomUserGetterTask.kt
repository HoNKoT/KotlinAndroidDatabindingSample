package jp.chau2chaun2.kotlindatabindingsample.task

import android.databinding.ObservableBoolean
import android.util.Log
import jp.chau2chaun2.kotlindatabindingsample.net.client.IApiRandomUser


class RandomUserGetterTask(private val apiRandomUser: IApiRandomUser) {

    val loading = ObservableBoolean(false)

    fun execute() {
        Thread(Runnable {
            Log.e("test", apiRandomUser.getRandomUser().toString())
        }).start()
    }
}
