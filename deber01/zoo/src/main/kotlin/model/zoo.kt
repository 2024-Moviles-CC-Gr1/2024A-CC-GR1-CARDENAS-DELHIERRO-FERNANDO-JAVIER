package model

import java.time.LocalDate

data class Zoologico(
    val nombre: String,
    val locate: String,
    val dateFundation: LocalDate,
    val caoacityMax: Int,
    val animals: MutableList<Animal> = mutableListOf()
)