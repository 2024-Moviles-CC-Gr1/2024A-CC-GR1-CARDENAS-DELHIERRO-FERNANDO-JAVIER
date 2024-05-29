package model
import java.time.LocalDate

data class Animal(
    val name: String,
    val specie: String,
    val age: Int,
    val dateInput: LocalDate,
    val weight: Double,
    val placeOfOrigin: String
)