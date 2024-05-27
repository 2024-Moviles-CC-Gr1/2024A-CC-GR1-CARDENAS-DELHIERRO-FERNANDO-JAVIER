package zoologico

import model.Animal
import model.Zoologico
import java.time.LocalDate

fun main(){
    //Animals
    val animal1 = Animal("Pablo","Elefante",22, LocalDate.now(),100.0,)
    //println(animal1)
    val animal2 = Animal("Mattew","Bicho",1, LocalDate.now(),5.3,)


    //Zoo
    val zoo1 = Zoologico(
        name = "ZOO-Fercho",
        locate = "Quito-Ecuador",
        dateFundation = LocalDate.of(1970, 1, 1),
        capacityMax = 100,
        animals = mutableListOf(animal1, animal2)
    )
    println(zoo1)
    println(zoo1.animals)
}