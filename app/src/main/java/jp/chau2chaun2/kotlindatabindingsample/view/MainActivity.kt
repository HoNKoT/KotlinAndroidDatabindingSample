@file:Suppress("UNUSED_PARAMETER")

package jp.chau2chaun2.kotlindatabindingsample.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import jp.chau2chaun2.kotlindatabindingsample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickBMICalculate(view: View) = startActivity(BMICalculateActivity.getIntent(this))
}
