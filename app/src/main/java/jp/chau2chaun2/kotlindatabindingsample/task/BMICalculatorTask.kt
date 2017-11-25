package jp.chau2chaun2.kotlindatabindingsample.task

import android.databinding.ObservableBoolean
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person



class BMICalculatorTask {

    val loading = ObservableBoolean(false)

    fun execute(person: Person) {
        Thread(Runnable {
            loading.set(true)

            person.calculateBmi()

            // for presentation
            Thread.sleep(2000)

            loading.set(false)
        }).start()
    }
}
