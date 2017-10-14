package jp.chau2chaun2.kotlindatabindingsample.task

import android.databinding.ObservableBoolean
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter



class BMICalculatorTask {

    val loading = ObservableBoolean(false)

    fun execute(presenter: PersonPresenter) {
        Thread(Runnable {
            loading.set(true)

            presenter.calculateBmi()

            // for presentation
            Thread.sleep(2000)

            loading.set(false)
        }).start()
    }
}
