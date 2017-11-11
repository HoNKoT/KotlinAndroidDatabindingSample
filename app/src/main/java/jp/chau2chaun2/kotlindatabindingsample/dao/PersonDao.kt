package jp.chau2chaun2.kotlindatabindingsample.dao

import jp.chau2chaun2.kotlindatabindingsample.model.Gender
import jp.chau2chaun2.kotlindatabindingsample.model.orma.OrmaDatabase
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person_Relation
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Person_Updater
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Kotlinで書くとNonExistentClass参照できないエラーで死ぬ
 */
@Singleton
class PersonDao @Inject constructor(private val mOrma: OrmaDatabase) {

    private fun relation(): Person_Relation = mOrma.relationOfPerson()

    private fun relationById(id: Long): Person_Relation = relation().idEq(id)

    private fun relationInMale(): Person_Relation = relation().sexEq(Gender.Male)

    private fun relationInFemale(): Person_Relation = relation().sexEq(Gender.Female)

    val isEmpty: Boolean get() = relation().isEmpty

    fun findAll(): List<Person> = relation().selector().toList()

    fun findById(id: Long): Person? = relationById(id).selector().valueOrNull()

    fun insert(person: Person): Long = relation().inserter().execute(person).also { person.id = it }

    fun insert(persons: List<Person>) {
        relation().inserter().executeAll(persons)
    }

    private fun getUpdaterBy(person: Person): Person_Updater = relationById(person.id).updater()

    fun update(person: Person): Int {
        return getUpdaterBy(person).apply {
            name(person.name)
            sex(person.sex)
            height(person.height)
            weight(person.weight)
            bmi(person.bmi)
            test(person.test)
        }.execute()
    }

    fun updateBmi(person: Person): Int {
        return getUpdaterBy(person).apply {
            height(person.height)
            weight(person.weight)
            bmi(person.bmi)
        }.execute()
    }

    fun delete(person: Person): Int = relationById(person.id).deleter().execute()

    fun deleteAll(): Int = relation().deleter().execute()
}
