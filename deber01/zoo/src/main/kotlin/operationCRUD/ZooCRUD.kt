package operationCRUD

import operationCRUD.AnimalCRUD.read
import operationCRUD.AnimalCRUD.save
import model.Zoologico
import java.io.File
import java.time.LocalDate

object ZooCRUD {
    //create db file txt
    private val fileZoo = File("DB_Zoo.txt")
    //private val file1 = File("DB_Animals.txt")

    //Funtion Read
    fun read(): MutableList<Zoologico> {
        val animals = AnimalCRUD.read()
        if (!fileZoo.exists()) return mutableListOf()
        return fileZoo.readLines().map { line ->
            val part = line.split(";")
            val zoologico = Zoologico(
                name = part[0],
                locate = part[1],
                dateFundation = LocalDate.parse(part[2]),
                capacityMax = part[3].toInt()
            )
            // Asignar animales al zoológico
            zoologico.animals.addAll(animals.filter { it.zooName == zoologico.name })
            zoologico
        }.toMutableList()
    }

    fun save (zoologico: List<Zoologico>) {
        fileZoo.writeText(zoologico.joinToString("\n"){ zoo ->
            "${zoo.name};${zoo.locate};${zoo.dateFundation};${zoo.capacityMax}"
        })
    }
    fun updateZoo (index: Int, zoologico: Zoologico) {
        val zoos = read()
        if (index in zoos.indices) {
            zoos[index] = zoologico
            save(zoos)
        }
    }

    //Funtion Create
    fun createZoo (zoologico: Zoologico) {
        val zoos = read()
        zoos.add(zoologico)
        save(zoos)
    }
}

    //Funtion update

    //Funtion delete
    fun deleteZoo (index: Int) {
        val zoos = read()
        if (index in zoos.indices) {
            zoos.removeAt(index)
            save(zoos)
        }
    }

