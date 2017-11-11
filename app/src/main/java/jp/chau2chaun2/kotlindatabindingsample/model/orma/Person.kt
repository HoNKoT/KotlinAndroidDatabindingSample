package jp.chau2chaun2.kotlindatabindingsample.model.orma

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

    val displayBmi: String get() = bmi?.let { String.format("BMI: %.1f", it) } ?: ""

    val canCalculate: Boolean get() =
        height?.let { it > 0 } == true
                && weight?.let { it > 0 } == true

    fun calculateBmi() {
        if (canCalculate) {
            weight?.let { weight ->
                height?.let { height ->
                    bmi = weight / ((height / 100) * (height / 100))
                }
            }
        } else {
            bmi = null
        }
    }
}
