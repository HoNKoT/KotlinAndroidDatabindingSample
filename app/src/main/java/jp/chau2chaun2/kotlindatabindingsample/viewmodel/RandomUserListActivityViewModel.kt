package jp.chau2chaun2.kotlindatabindingsample.viewmodel

import jp.chau2chaun2.kotlindatabindingsample.presenter.RandomUserPresenter
import javax.inject.Inject

class RandomUserListActivityViewModel @Inject constructor(private val presenter: RandomUserPresenter) {

    fun addSingle(callback: () -> Unit) = presenter.getNewRandomUser(callback)

    fun addMultiple(callback: () -> Unit) = presenter.getNewRandomUsers(callback, 3)
}
