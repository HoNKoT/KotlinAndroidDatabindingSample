package jp.chau2chaun2.kotlindatabindingsample.task

import android.databinding.ObservableBoolean
import android.os.AsyncTask
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter

class BMICalculatorTask : AsyncTask<PersonPresenter, Unit, Unit>() {

    val loading = ObservableBoolean(false)

    override fun doInBackground(vararg presenters: PersonPresenter) {
        loading.set(true)
        presenters.map { it.calculateBmi() }

        // for presentation
        Thread.sleep(2000)

        loading.set(false)
    }
}
