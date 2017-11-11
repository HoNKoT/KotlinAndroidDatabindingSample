package jp.chau2chaun2.kotlindatabindingsample.presenter

import jp.chau2chaun2.kotlindatabindingsample.model.Gender
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person
import java.util.*

class PersonPresenter {

    constructor() {
        person = Person()
    }

    private constructor(person: Person) {
        this.person = person
    }

    val person: Person

    val canCalculate: Boolean get() =
        person.height?.let { it > 0 } == true
                && person.weight?.let { it > 0 } == true

    fun calculateBmi() {
        if (canCalculate) {
            person.apply {
                weight?.let { weight ->
                    height?.let { height ->
                        bmi = weight / ((height / 100) * (height / 100))
                        displayBmi.set(String.format("BMI: %.1f", bmi))
                    }
                }
            }
        } else {
            person.bmi = null
            person.displayBmi.set("")
        }
    }

    companion object {
        fun from(person: Person): PersonPresenter = PersonPresenter(person)

        fun asDummy(): PersonPresenter {
            return PersonPresenter().apply {
                person.apply {
                    val randomGen = Random()
                    sex = if (randomGen.nextInt(2) > 0) Gender.Male else Gender.Female
                    randomGen.nextInt(350).let {
                        height = (1500 + it).toDouble() / 10
                    }
                    randomGen.nextInt(200).let {
                        weight = (500 + it).toDouble() / 10
                    }
                }

                person.name = Integer.toHexString(person.hashCode())
            }
        }
    }
}
