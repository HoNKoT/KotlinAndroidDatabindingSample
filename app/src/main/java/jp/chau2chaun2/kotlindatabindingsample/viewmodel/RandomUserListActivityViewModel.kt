package jp.chau2chaun2.kotlindatabindingsample.viewmodel

import android.content.Context
import android.widget.Toast
import jp.chau2chaun2.kotlindatabindingsample.presenter.RandomUserPresenter
import javax.inject.Inject

class RandomUserListActivityViewModel @Inject constructor(context: Context,
                                                          private val presenter: RandomUserPresenter) {

    val toast: Toast = Toast.makeText(context, "", Toast.LENGTH_LONG)

    var loadingUserCount: Int = 0

    fun addSingle(callback: () -> Unit) {
        loadingUserCount++
        showLoadingToast()
        presenter.getNewRandomUser {
            --loadingUserCount
            showLoadingToast()
            callback()
        }
    }

    fun addMultiple(callback: () -> Unit) {
        loadingUserCount += 10
        showLoadingToast()
        presenter.getNewRandomUsers(10) {
            --loadingUserCount
            showLoadingToast()
            callback()
        }
    }

    private fun showLoadingToast() {
        if (loadingUserCount > 0) {
            toast.setText("New User loading... / ${loadingUserCount} user(s).")
        } else {
            toast.setText("LOAD COMPLETED")
        }
        toast.show()
    }

    fun deleteAll() {
        val recordCount = presenter.deleteAll()
        toast.setText("Deleted $recordCount Users")
        toast.show()
    }
}
