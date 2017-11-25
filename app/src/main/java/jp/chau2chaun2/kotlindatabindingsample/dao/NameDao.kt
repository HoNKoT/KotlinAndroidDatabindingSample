package jp.chau2chaun2.kotlindatabindingsample.dao

import com.github.gfx.android.orma.SingleAssociation
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Name_Relation
import jp.chau2chaun2.kotlindatabindingsample.model.orma.OrmaDatabase
import jp.chau2chaun2.kotlindatabindingsample.model.orma.RandomUser
import javax.inject.Inject

class NameDao @Inject constructor(private val ormaDatabase: OrmaDatabase) {

    val relation: Name_Relation = ormaDatabase.relationOfName()

    fun insert(randomUser: RandomUser) {
        randomUser.results.forEach { result ->
            result.serializedName?.let { name ->
                relation.inserter().execute(name).also {
                    name.id = it
                    result.name = SingleAssociation.just(it)
                }
            }
        }
    }
}
