import animal.Animal
import java.time.LocalDate

data class zoo(
    val name: String,
    val locate: String,
    val dateFundation: LocalDate,
    val capacityMax: Int,
    val animals: MutableList<Animal> = mutableListOf()
)