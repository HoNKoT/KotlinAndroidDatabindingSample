package jp.chau2chaun2.kotlindatabindingsample.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import jp.chau2chaun2.kotlindatabindingsample.R
import jp.chau2chaun2.kotlindatabindingsample.databinding.ActivityUserListBinding
import jp.chau2chaun2.kotlindatabindingsample.view.adapter.RandomUserListAdapter
import jp.chau2chaun2.kotlindatabindingsample.viewmodel.RandomUserListActivityViewModel
import javax.inject.Inject

class RandomUserListActivity : BaseActivity() {

    @Inject lateinit var adapter: RandomUserListAdapter

    @Inject lateinit var viewModel: RandomUserListActivityViewModel

    private val binding: ActivityUserListBinding by lazy {
        DataBindingUtil.setContentView<ActivityUserListBinding>(this, R.layout.activity_user_list)
    }

    override fun onActivityInject() {
        mComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.list.adapter = this.adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_single -> {
                viewModel.addSingle { adapter.notifyDataSetChanged() }
            }

            R.id.add_multiple -> {
                viewModel.addMultiple { adapter.notifyDataSetChanged() }
            }

            R.id.delete_all -> {
                viewModel.deleteAll()
                adapter.notifyDataSetChanged()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, RandomUserListActivity::class.java)
        }
    }
}