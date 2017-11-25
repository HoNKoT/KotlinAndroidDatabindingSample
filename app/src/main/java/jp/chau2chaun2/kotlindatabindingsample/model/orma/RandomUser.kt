package jp.chau2chaun2.kotlindatabindingsample.model.orma

import com.github.gfx.android.orma.SingleAssociation
import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Table
import com.google.gson.annotations.SerializedName

data class RandomUser(val info: Info,
                      val results: List<Result>)

data class Info(val seed: String,
                val results: Int,
                val page: Int,
                val version: String)

@Table("user")
class Result {

    @PrimaryKey
    @Transient
    var id: Long = 0

    @Column lateinit var gender: String

    @Column lateinit var email: String

    @Column lateinit var registered: String

    @Column lateinit var dob: String

    @Column lateinit var phone: String

    @Column lateinit var cell: String

    @Column lateinit var nat: String

    @SerializedName("name")
    var serializedName: Name? = null

    @Column
    @Transient
    var name: SingleAssociation<Name> = SingleAssociation.just(0)
}

@Table("name")
class Name {

    @PrimaryKey
    @Transient
    var id: Long = 0

    @Column lateinit var first: String

    @Column lateinit var last: String

    @Column lateinit var title: String
}
