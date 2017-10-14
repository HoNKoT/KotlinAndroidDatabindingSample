package jp.chau2chaun2.kotlindatabindingsample.presenter

import jp.chau2chaun2.kotlindatabindingsample.model.Person

class PersonPresenter {

    constructor() {
        person = Person()
    }

    private constructor(person: Person) {
        this.person = person
    }

    val person: Person

    val canCalculate: Boolean get() = person.height != null && person.weight != null

    fun calculateBmi() {
        if (canCalculate) {
            person.apply {
                weight?.let { weight ->
                    height?.let { height ->
                        bmi = weight / height
                    }
                }
            }
        }
    }

    companion object {
        fun from(person: Person): PersonPresenter = PersonPresenter(person)
    }
}
