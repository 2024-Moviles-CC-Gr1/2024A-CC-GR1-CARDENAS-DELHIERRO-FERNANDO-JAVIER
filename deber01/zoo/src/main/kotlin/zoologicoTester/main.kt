package zoologicoTester

import model.Animal
import model.Zoologico
import operationCRUD.AnimalCRUD
import java.time.LocalDate
import java.util.*

fun main() {
    // Animals
    val animal1 = Animal("Pablo", "Elefante", 22, LocalDate.now(), 100.0, "ZooFercho")
    val animal2 = Animal("Mattew", "Bicho", 1, LocalDate.now(), 5.3, "ZooFercho")

    // Zoo
    val zoo1 = Zoologico(
        name = "ZOO-Fercho",
        locate = "Quito-Ecuador",
        dateFundation = LocalDate.of(1970, 1, 1),
        capacityMax = 100,
        animals = mutableListOf(animal1, animal2)
    )

    val scanner = Scanner(System.`in`)
    var option: Int

    do {
        println("\n--- Menú Principal ---")
        println("1. Gestión de Animales")
        println("2. Salir")
        print("Selecciona una opción: ")
        option = scanner.nextInt()
        scanner.nextLine()  // Consumir nueva línea

        when (option) {
            1 -> menuAnimales(scanner)
            2 -> println("Saliendo del programa...")
            else -> println("Opción inválida, intenta de nuevo.")
        }
    } while (option != 2)
}

fun menuZoologicos(scanner: Scanner) {
    println("Estamos en construcción")
}

fun menuAnimales(scanner: Scanner) {
    var option: Int

    do {
        println("\n--- Gestión de Animales ---")
        println("1. Crear Animal")
        println("2. Leer Animales")
        println("3. Actualizar Animal")
        println("4. Eliminar Animal")
        println("5. Volver al Menú Principal")
        print("Selecciona una opción: ")
        option = scanner.nextInt()
        scanner.nextLine()  // Consumir nueva línea

        when (option) {
            1 -> {
                print("Nombre: ")
                val nombre = scanner.nextLine()
                print("Especie: ")
                val especie = scanner.nextLine()
                print("Edad: ")
                val edad = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea
                print("Fecha de Ingreso (YYYY-MM-DD): ")
                val fechaIngreso = LocalDate.parse(scanner.nextLine())
                print("Peso: ")
                val peso = scanner.nextDouble()
                scanner.nextLine()  // Consumir nueva línea
                print("Lugar de origen: ")
                val zoologicoNombre = scanner.nextLine()

                val animal = Animal(nombre, especie, edad, fechaIngreso, peso, zoologicoNombre)
                AnimalCRUD.create(animal)
                println("Animal creado exitosamente.")
            }
            2 -> {
                val animales = AnimalCRUD.read()
                println("\n--- Lista de Animales ---")
                animales.forEachIndexed { index, animal ->
                    println("$index: $animal")
                }
            }
            3 -> {
                print("Índice del Animal a actualizar: ")
                val index = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea

                val animales = AnimalCRUD.read()
                if (index in animales.indices) {
                    print("Nuevo Nombre: ")
                    val nombre = scanner.nextLine()
                    print("Nueva Especie: ")
                    val especie = scanner.nextLine()
                    print("Nueva Edad: ")
                    val edad = scanner.nextInt()
                    scanner.nextLine()  // Consumir nueva línea
                    print("Nueva Fecha de Ingreso (YYYY-MM-DD): ")
                    val fechaIngreso = LocalDate.parse(scanner.nextLine())
                    print("Nuevo Peso: ")
                    val peso = scanner.nextDouble()
                    scanner.nextLine()  // Consumir nueva línea
                    print("Nuevo lugar de origen ")
                    val origen  = scanner.nextLine()

                    val animal = Animal(nombre, especie, edad, fechaIngreso, peso, origen)
                    AnimalCRUD.update(index, animal)
                    println("Animal actualizado exitosamente.")
                } else {
                    println("Índice inválido.")
                }
            }
            4 -> {
                print("Índice del Animal a eliminar: ")
                val index = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea

                val animales = AnimalCRUD.read()
                if (index in animales.indices) {
                    AnimalCRUD.delete(index)
                    println("Animal eliminado exitosamente.")
                } else {
                    println("Índice inválido.")
                }
            }
            5 -> println("Volviendo al Menú Principal...")
            else -> println("Opción inválida, intenta de nuevo.")
        }
    } while (option != 5)
}
