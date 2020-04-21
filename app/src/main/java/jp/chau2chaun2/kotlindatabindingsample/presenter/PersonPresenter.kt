package jp.chau2chaun2.kotlindatabindingsample.presenter

import android.database.Cursor
import jp.chau2chaun2.kotlindatabindingsample.dao.PersonDao
import jp.chau2chaun2.kotlindatabindingsample.model.Gender
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person_Schema
import java.util.*
import javax.inject.Inject

class PersonPresenter @Inject constructor(private val personDao: PersonDao) {

    fun initializeIfNeeded() {
        if (personDao.isEmpty) {
            // insert some data
            val persons = ArrayList<Person>().apply {
                for (i in 0 until 50) {
                    add(createAsDummy)
                }
            }

            // insert all
            personDao.insert(persons)
        }
    }

    fun getBmiListCursor(): Cursor {
        return personDao.relation().selector().executeWithColumns(
                Person_Schema.INSTANCE.height.name,
                Person_Schema.INSTANCE.weight.name,
                Person_Schema.INSTANCE.bmi.name
        )
    }

    fun getAllPerson(): List<Person> = personDao.findAll()

    companion object {

        val create: Person get() = Person()

        fun createByCursor(cursor: Cursor): Person {
            return create.apply {
                height = cursor.getDouble(0)
                weight = cursor.getDouble(1)
                bmi = cursor.getDouble(2)
            }
        }

        val createAsDummy: Person get() {
            return create.apply {
                val randomGen = Random()
                sex = if (randomGen.nextInt(2) > 0) Gender.Male else Gender.Female
                randomGen.nextInt(350).let {
                    height = (1500 + it).toDouble() / 10
                }
                randomGen.nextInt(200).let {
                    weight = (500 + it).toDouble() / 10
                }

                name = Integer.toHexString(randomGen.hashCode())
            }
        }
    }
}
