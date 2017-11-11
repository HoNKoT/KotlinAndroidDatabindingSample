package jp.chau2chaun2.kotlindatabindingsample.model.orma

import com.github.gfx.android.orma.annotation.*

@Table
class Building {

    @PrimaryKey(autoincrement = true)
    var id: Long = 0

    @Column(indexed = true)
    @get:Getter
    @set:Setter
    var name: String? = null

    @Column
    @get:Getter
    @set:Setter
    var lat: Double = 0.0

    @Column
    @get:Getter
    @set:Setter
    var lng: Double = 0.0
}
