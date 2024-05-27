package model

import java.time.LocalDate

data class Zoologico(
    val name: String,
    val locate: String,
    val dateFundation: LocalDate,
    val capacityMax: Int,
    val animals: MutableList<Animal> = mutableListOf()
)