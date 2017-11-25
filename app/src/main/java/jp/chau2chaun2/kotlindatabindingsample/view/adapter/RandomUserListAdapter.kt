package jp.chau2chaun2.kotlindatabindingsample.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import jp.chau2chaun2.kotlindatabindingsample.databinding.RowUserListBinding
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Result
import jp.chau2chaun2.kotlindatabindingsample.presenter.RandomUserPresenter
import javax.inject.Inject

class RandomUserListAdapter @Inject constructor(context: Context,
                                                private val presenter: RandomUserPresenter) : BaseAdapter() {

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    private lateinit var users: List<Result>

    init {
        updateModel()
    }

    private fun updateModel() {
        users = presenter.getCurrentUsers()
    }

    override fun notifyDataSetChanged() {
        updateModel()
        super.notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = convertView
                ?.let { DataBindingUtil.findBinding<RowUserListBinding>(convertView) }
                ?: RowUserListBinding.inflate(layoutInflater)

        binding.data = getItem(position)
        binding.name = getItem(position).name.get()

        return binding.root
    }

    override fun getItem(position: Int): Result = users[position]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = users.size

}
