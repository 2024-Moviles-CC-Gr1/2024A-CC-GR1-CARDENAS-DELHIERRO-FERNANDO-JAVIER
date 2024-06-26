package operationCRUD

import model.Animal
import model.Zoologico
import java.io.File
import java.time.LocalDate

object ZooCRUD {
    // Create db file txt
    private val fileZoo = File("DB_Zoo.txt")

    init {
        if (!fileZoo.exists()) {
            fileZoo.createNewFile()
        }
    }

    // Function Read
    fun read(): MutableList<Zoologico> {
        if (!fileZoo.exists()) return mutableListOf()
        return fileZoo.readLines().mapNotNull { line ->
            try {
                val part = line.split(";")
                val animals = AnimalCRUD.read().filter { it.placeOfOrigin == part[0] }.toMutableList()
                Zoologico(
                    name = part[0],
                    locate = part[1],
                    dateFundation = LocalDate.parse(part[2]),
                    capacityMax = part[3].toInt(),
                    animals = animals
                )
            } catch (e: Exception) {
                println("Error reading line: $line")
                null
            }
        }.toMutableList()
    }

    // Function Save
    fun saveToFile(zoos: List<Zoologico>) {
        fileZoo.writeText(zoos.joinToString("\n") { zoo ->
            "${zoo.name};${zoo.locate};${zoo.dateFundation};${zoo.capacityMax}"
        })
        // Also save the animals
        AnimalCRUD.saveToFile(zoos.flatMap { it.animals })
    }

    // Function Create
    fun create(zoo: Zoologico) {
        val zoos = read()
        zoos.add(zoo)
        saveToFile(zoos)
    }

    // Function Delete
    fun delete(index: Int) {
        val zoos = read()
        if (index in zoos.indices) {
            zoos.removeAt(index)
            saveToFile(zoos)
        } else {
            println("Error: Invalid index for delete")
        }
    }

    // Function Update
    fun update(index: Int, zoo: Zoologico) {
        val zoos = read()
        if (index in zoos.indices) {
            zoos[index] = zoo
            saveToFile(zoos)
        } else {
            println("Error: Invalid index for update")
        }
    }

    // Add Animal to Zoo
    fun addAnimalToZoo(zooIndex: Int, animal: Animal) {
        val zoos = read()
        if (zooIndex in zoos.indices) {
            zoos[zooIndex].animals.add(animal)
            saveToFile(zoos)
        } else {
            println("Error: Invalid zoo index for adding animal")
        }
    }

    // Remove Animal from Zoo
    fun removeAnimalFromZoo(zooIndex: Int, animalIndex: Int) {
        val zoos = read()
        if (zooIndex in zoos.indices && animalIndex in zoos[zooIndex].animals.indices) {
            zoos[zooIndex].animals.removeAt(animalIndex)
            saveToFile(zoos)
        } else {
            println("Error: Invalid indices for removing animal")
        }
    }

    // Update Animal in Zoo
    fun updateAnimalInZoo(zooIndex: Int, animalIndex: Int, animal: Animal) {
        val zoos = read()
        if (zooIndex in zoos.indices && animalIndex in zoos[zooIndex].animals.indices) {
            zoos[zooIndex].animals[animalIndex] = animal
            saveToFile(zoos)
        } else {
            println("Error: Invalid indices for updating animal")
        }
    }

    }

