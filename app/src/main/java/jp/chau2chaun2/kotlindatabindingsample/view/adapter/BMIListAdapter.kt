package jp.chau2chaun2.kotlindatabindingsample.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import jp.chau2chaun2.kotlindatabindingsample.databinding.RowListBinding
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter
import jp.chau2chaun2.kotlindatabindingsample.task.BMICalculatorTask

class BMIListAdapter(context: Context, private val persons: List<Person>): BaseAdapter(), AdapterView.OnItemClickListener {

    private val mLayoutInflater = LayoutInflater.from(context)

    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        view?.let {
            Log.d("DLog", getItem(position).toString())
            DataBindingUtil.findBinding<RowListBinding>(it).also {
                it.task = BMICalculatorTask().apply {
                    execute(PersonPresenter.from(getItem(position))) }
            }
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = convertView
                ?.let { DataBindingUtil.findBinding<RowListBinding>(convertView) }
                ?: RowListBinding.inflate(mLayoutInflater)

        binding.data = getItem(position)
        return binding.root
    }

    override fun getItem(position: Int): Person = persons[position]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = persons.size


}
