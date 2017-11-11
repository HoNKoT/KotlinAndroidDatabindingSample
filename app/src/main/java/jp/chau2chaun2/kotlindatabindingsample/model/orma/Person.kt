package jp.chau2chaun2.kotlindatabindingsample.model.orma

import android.databinding.ObservableField
import com.github.gfx.android.orma.SingleAssociation
import com.github.gfx.android.orma.annotation.*
import jp.chau2chaun2.kotlindatabindingsample.model.Gender

@Table
class Person {

    @PrimaryKey(autoincrement = true)
    var id: Long = 0

    @Column(indexed = true)
    @get:Getter
    @set:Setter
    var name: String? = null

    @Column(defaultExpr = "Male", indexed = true)
    @get:Getter
    @set:Setter
    var sex: Gender? = null

    @Column
    @get:Getter
    @set:Setter
    var height: Double? = null

    @Column
    @get:Getter
    @set:Setter
    var weight: Double? = null

    @Column
    @get:Getter
    @set:Setter
    var bmi: Double? = null

    @Column
    @get:Getter
    @set:Setter
    var test: String = ""

    @Column
    @get:Getter
    @set:Setter
    var building: SingleAssociation<Building>? = null

    val displayBmi = ObservableField<String>("")
}
