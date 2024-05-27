package operationCRUD

import operationCRUD.AnimalCRUD.read
import operationCRUD.AnimalCRUD.save
import model.Animal
import java.io.File
import java.time.LocalDate

object AnimalCRUD {
    //create db file txt
    private val fileAnimal = File("DB_Animals.txt")

    //Funtion Read
    fun read(): MutableList<Animal> {
        if (!fileAnimal.exists()) return mutableListOf()
        return fileAnimal.readLines().map { line ->
            val part = line.split(";")
            Animal(
                name = part[0],
                specie = part[1],
                age = part[2].toInt(),
                dateInput = LocalDate.parse(part[3]),
                weight = part[4].toDouble(),
                zooName = part[5]
            )
        }.toMutableList()
    }

    fun save (animal: List<Animal>) {
        fileAnimal.writeText(animal.joinToString("\n"){ an ->
            "${an.name};${an.specie};${an.age};${an.dateInput};${an.weight}"
        })
   }
    fun update(index: Int, animal: Animal) {
        val animals = read()
        if (index in animals.indices) {
            animals[index] = animal
            save(animals)
        }
    }

    //Funtion Create
    fun create (animal: Animal) {
        val animals = read()
        animals.add(animal)
        save(animals)
        }
    }

    //Funtion update
    fun update (index: Int, animal: Animal) {
        val animals = read()
        if (index in animals.indices) {
            animals[index] = animal
            save(animals)
        }
    }
    //Funtion delete

    fun delete (index: Int) {
       val animals = read()
        if (index in animals.indices) {
            animals.removeAt(index)
            save(animals)
        }
    }
