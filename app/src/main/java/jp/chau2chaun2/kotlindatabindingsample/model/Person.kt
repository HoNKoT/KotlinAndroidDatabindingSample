package jp.chau2chaun2.kotlindatabindingsample.model

data class Person(var name: String? = null,
                  var sex: Gender? = null,
                  var height: Double? = null,
                  var weight: Double? = null,
                  var bmi: Double? = null)
