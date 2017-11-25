package jp.chau2chaun2.kotlindatabindingsample.dao

import jp.chau2chaun2.kotlindatabindingsample.model.orma.OrmaDatabase
import jp.chau2chaun2.kotlindatabindingsample.model.orma.RandomUser
import jp.chau2chaun2.kotlindatabindingsample.model.orma.Result_Relation
import javax.inject.Inject

/**
 * Equals User Dao actually.
 */
class ResultDao @Inject constructor(private val ormaDatabase: OrmaDatabase) {

    val relation: Result_Relation = ormaDatabase.relationOfResult()

    fun insert(randomUser: RandomUser) {
        randomUser.results.forEach { result ->
            relation.inserter().execute(result).also { result.id = it }
        }
    }
}
