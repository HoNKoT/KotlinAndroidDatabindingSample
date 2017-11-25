package jp.chau2chaun2.kotlindatabindingsample.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import jp.chau2chaun2.kotlindatabindingsample.net.client.IApiRandomUser
import jp.chau2chaun2.kotlindatabindingsample.presenter.RandomUserPresenter
import jp.chau2chaun2.kotlindatabindingsample.task.RandomUserGetterTask
import javax.inject.Inject

class RandomUserListActivity : BaseActivity() {

    @Inject lateinit var presenter: RandomUserPresenter

    @Inject lateinit var apiRandomUser: IApiRandomUser

    override fun onActivityInject() {
        mComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RandomUserGetterTask(apiRandomUser).execute()
//        Log.e("test", "### ${presenter.getNewRandomUser().toString()}")
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, RandomUserListActivity::class.java)
        }
    }
}