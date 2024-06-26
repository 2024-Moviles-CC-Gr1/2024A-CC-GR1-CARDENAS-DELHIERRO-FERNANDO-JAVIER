package zoologicoTester

import model.Animal
import model.Zoologico
import operationCRUD.AnimalCRUD
import operationCRUD.ZooCRUD
import java.time.LocalDate
import java.util.*

fun main() {
    // Animals
    val animal1 = Animal("Pablo", "Elefante", 22, LocalDate.now(), 100.0, "ZOO-Fercho")
    val animal2 = Animal("Mattew", "Bicho", 1, LocalDate.now(), 5.3, "ZOO-Fercho")

    // Zoo
    val zoo1 = Zoologico(
        name = "ZOO-Fercho",
        locate = "Quito-Ecuador",
        dateFundation = LocalDate.of(1970, 1, 1),
        capacityMax = 100,
        animals = mutableListOf(animal1, animal2)
    )

    ZooCRUD.create(zoo1)

    val scanner = Scanner(System.`in`)
    var option: Int

    do {
        println("\n--- Menú Principal ---")
        println("1. Gestión de Zoológicos")
        println("2. Gestión de Animales")
        println("3. Salir")
        print("Selecciona una opción: ")
        option = scanner.nextInt()
        scanner.nextLine()  // Consumir nueva línea

        when (option) {
            1 -> menuZoologicos(scanner)
            2 -> menuAnimales(scanner)
            3 -> println("Saliendo del programa...")
            else -> println("Opción inválida, intenta de nuevo.")
        }
    } while (option != 3)
}

fun menuZoologicos(scanner: Scanner) {
    var option: Int

    do {
        println("\n--- Gestión de Zoológicos ---")
        println("1. Crear Zoológico")
        println("2. Leer Zoológicos")
        println("3. Actualizar Zoológico")
        println("4. Eliminar Zoológico")
        println("5. Añadir Animal a Zoológico")
        println("6. Eliminar Animal de Zoológico")
        println("7. Actualizar Animal en Zoológico")
        println("8. Volver al Menú Principal")
        print("Selecciona una opción: ")
        option = scanner.nextInt()
        scanner.nextLine()  // Consumir nueva línea

        when (option) {
            1 -> {
                print("Nombre: ")
                val nombre = scanner.nextLine()
                print("Ubicación: ")
                val ubicacion = scanner.nextLine()
                print("Fecha de Fundación (YYYY-MM-DD): ")
                val fechaFundacion = LocalDate.parse(scanner.nextLine())
                print("Capacidad Máxima: ")
                val capacidadMaxima = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea

                val zoo = Zoologico(nombre, ubicacion, fechaFundacion, capacidadMaxima)
                ZooCRUD.create(zoo)
                println("Zoológico creado exitosamente.")
            }
            2 -> {
                val zoologicos = ZooCRUD.read()
                println("\n--- Lista de Zoológicos ---")
                zoologicos.forEachIndexed { index, zoo ->
                    println("$index: $zoo")
                }
            }
            3 -> {
                print("Índice del Zoológico a actualizar: ")
                val index = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea

                val zoologicos = ZooCRUD.read()
                if (index in zoologicos.indices) {
                    print("Nuevo Nombre: ")
                    val nombre = scanner.nextLine()
                    print("Nueva Ubicación: ")
                    val ubicacion = scanner.nextLine()
                    print("Nueva Fecha de Fundación (YYYY-MM-DD): ")
                    val fechaFundacion = LocalDate.parse(scanner.nextLine())
                    print("Nueva Capacidad Máxima: ")
                    val capacidadMaxima = scanner.nextInt()
                    scanner.nextLine()  // Consumir nueva línea

                    val zoo = Zoologico(nombre, ubicacion, fechaFundacion, capacidadMaxima, zoologicos[index].animals)
                    ZooCRUD.update(index, zoo)
                    println("Zoológico actualizado exitosamente.")
                } else {
                    println("Índice inválido.")
                }
            }
            4 -> {
                print("Índice del Zoológico a eliminar: ")
                val index = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea

                val zoologicos = ZooCRUD.read()
                if (index in zoologicos.indices) {
                    ZooCRUD.delete(index)
                    println("Zoológico eliminado exitosamente.")
                } else {
                    println("Índice inválido.")
                }
            }
            5 -> {
                print("Índice del Zoológico: ")
                val zooIndex = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea

                val zoologicos = ZooCRUD.read()
                if (zooIndex in zoologicos.indices) {
                    print("Nombre del Animal: ")
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

                    val animal = Animal(nombre, especie, edad, fechaIngreso, peso, zoologicos[zooIndex].name)
                    ZooCRUD.addAnimalToZoo(zooIndex, animal)
                    println("Animal añadido exitosamente al Zoológico.")
                } else {
                    println("Índice de Zoológico inválido.")
                }
            }
            6 -> {
                print("Índice del Zoológico: ")
                val zooIndex = scanner.nextInt()
                print("Índice del Animal a eliminar: ")
                val animalIndex = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea

                val zoologicos = ZooCRUD.read()
                if (zooIndex in zoologicos.indices) {
                    ZooCRUD.removeAnimalFromZoo(zooIndex, animalIndex)
                    println("Animal eliminado exitosamente del Zoológico.")
                } else {
                    println("Índice inválido.")
                }
            }
            7 -> {
                print("Índice del Zoológico: ")
                val zooIndex = scanner.nextInt()
                print("Índice del Animal a actualizar: ")
                val animalIndex = scanner.nextInt()
                scanner.nextLine()  // Consumir nueva línea

                val zoologicos = ZooCRUD.read()
                if (zooIndex in zoologicos.indices && animalIndex in zoologicos[zooIndex].animals.indices) {
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

                    val animal = Animal(nombre, especie, edad, fechaIngreso, peso, zoologicos[zooIndex].name)
                    ZooCRUD.updateAnimalInZoo(zooIndex, animalIndex, animal)
                    println("Animal actualizado exitosamente en el Zoológico.")
                } else {
                    println("Índices inválidos.")
                }
            }
            8 -> println("Volviendo al Menú Principal...")
            else -> println("Opción inválida, intenta de nuevo.")
        }
    } while (option != 8)
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
                    val origen = scanner.nextLine()

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
