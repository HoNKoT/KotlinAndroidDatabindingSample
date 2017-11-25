package jp.chau2chaun2.kotlindatabindingsample.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableField
import android.util.Log
import jp.chau2chaun2.kotlindatabindingsample.BR
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter
import javax.inject.Inject

class BMIRealtimeCalculateViewModel @Inject constructor() : BaseObservable() {

    private val person: Person = PersonPresenter.create

    var height: String = person.height?.toString() ?: ""
        @Bindable get() = field
        set(value) {
            Log.e("test", "height setter")
            field = value
            notifyPropertyChanged(BR.height)
            person.height = value.takeIf { it.isNotEmpty() }?.toDouble()
            updateBmi()
        }

    var weight: String = person.weight?.toString() ?: ""
        @Bindable get() = field
        set(value) {
            Log.e("test", "weight setter")
            field = value
            notifyPropertyChanged(BR.weight)
            person.weight = value.takeIf { it.isNotEmpty() }?.toDouble()
            updateBmi()
        }

    var displayBmi = ObservableField<String>("")

    private fun updateBmi() {
        person.calculateBmi()
        displayBmi.set(person.displayBmi)
    }
}
