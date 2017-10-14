package jp.chau2chaun2.kotlindatabindingsample.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.chau2chaun2.kotlindatabindingsample.R
import jp.chau2chaun2.kotlindatabindingsample.databinding.ActivityBmiListBinding
import jp.chau2chaun2.kotlindatabindingsample.model.Person
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter

class BMIListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityBmiListBinding>(this, R.layout.activity_bmi_list).also {
            val persons = ArrayList<Person>()
            for (i in 0 until 50) {
                persons.add(PersonPresenter.asDummy().person)
            }
            it.persons = persons
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, BMIListActivity::class.java)
        }
    }
}
