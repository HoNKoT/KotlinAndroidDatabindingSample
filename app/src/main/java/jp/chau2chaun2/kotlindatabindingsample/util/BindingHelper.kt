package jp.chau2chaun2.kotlindatabindingsample.util

import android.databinding.BindingAdapter
import android.widget.ListView
import jp.chau2chaun2.kotlindatabindingsample.model.Person
import jp.chau2chaun2.kotlindatabindingsample.view.adapter.BMIListAdapter

@BindingAdapter("data")
fun ListView.loadAdapter(data: List<Person>) {
    BMIListAdapter(this.context, data).also {
        this.adapter = it
        this.onItemClickListener = it
    }
}
