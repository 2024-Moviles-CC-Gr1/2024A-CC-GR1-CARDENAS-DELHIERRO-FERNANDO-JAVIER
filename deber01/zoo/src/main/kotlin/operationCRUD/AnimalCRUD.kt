package operationCRUD

import model.Animal
import java.io.File
import java.time.LocalDate

object AnimalCRUD {
    // Create db file txt
    private val fileAnimal = File("DB_Animals.txt")

    init {
        if (!fileAnimal.exists()) {
            fileAnimal.createNewFile()
        }
    }

    // Function Read
    fun read(): MutableList<Animal> {
        if (!fileAnimal.exists()) return mutableListOf()
        return fileAnimal.readLines().mapNotNull { line ->
            try {
                val part = line.split(";")
                Animal(
                    name = part[0],
                    specie = part[1],
                    age = part[2].toInt(),
                    dateInput = LocalDate.parse(part[3]),
                    weight = part[4].toDouble(),
                    placeOfOrigin = part[5]
                )
            } catch (e: Exception) {
                println("Error reading line: $line")
                null
            }
        }.toMutableList()
    }

    // Function Save
    fun saveToFile(animals: List<Animal>) {
        fileAnimal.writeText(animals.joinToString("\n") { an ->
            "${an.name};${an.specie};${an.age};${an.dateInput};${an.weight};${an.placeOfOrigin}"
        })
    }

    // Function Create
    fun create(animal: Animal) {
        val animals = read()
        animals.add(animal)
        saveToFile(animals)
    }

    // Function Delete
    fun delete(index: Int) {
        val animals = read()
        if (index in animals.indices) {
            animals.removeAt(index)
            saveToFile(animals)
        } else {
            println("Error: Invalid index for delete")
        }
    }

    // Function Update
    fun update(index: Int, animal: Animal) {
        val animals = read()
        if (index in animals.indices) {
            animals[index] = animal
            saveToFile(animals)
        } else {
            println("Error: Invalid index for update")
        }
    }
}
