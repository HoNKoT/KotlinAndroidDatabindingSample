package jp.chau2chaun2.kotlindatabindingsample.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableField
import android.util.Log
import jp.chau2chaun2.kotlindatabindingsample.BR
import jp.chau2chaun2.kotlindatabindingsample.presenter.PersonPresenter

class BMIRealtimeCalculateViewModel(private val presenter: PersonPresenter) : BaseObservable() {

    var height: String = ""
        @Bindable get() = field
        set(value) {
            Log.e("test", "height setter")
            field = value
            notifyPropertyChanged(BR.height)
            presenter.person.height = value.takeIf { it.isNotEmpty() }?.toDouble()
            updateBmi()
        }

    var weight: String = ""
        @Bindable get() = field
        set(value) {
            Log.e("test", "weight setter")
            field = value
            notifyPropertyChanged(BR.weight)
            presenter.person.weight = value.takeIf { it.isNotEmpty() }?.toDouble()
            updateBmi()
        }

    var inputText: String = ""
        @Bindable get() = field
        @Bindable set(value) {
            field = value
            notifyPropertyChanged(BR.inputText)
        }

    var displayBmi = ObservableField<String>("")

    private fun updateBmi() {
        presenter.calculateBmi()
        displayBmi.set(presenter.person.displayBmi.get())
    }
}
