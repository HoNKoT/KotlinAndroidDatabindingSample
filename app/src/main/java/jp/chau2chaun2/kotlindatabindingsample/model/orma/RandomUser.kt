package jp.chau2chaun2.kotlindatabindingsample.model.orma

data class RandomUser(val info: Info,
                      val results: List<Result>)

data class Info(val seed: String,
                val results: Int,
                val page: Int,
                val version: String)

data class Result(val gender: String,
                  val email: String,
                  val registered: String,
                  val dob: String,
                  val phone: String,
                  val cell: String)
