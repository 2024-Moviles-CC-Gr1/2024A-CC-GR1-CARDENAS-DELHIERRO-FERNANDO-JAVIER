Proyecto CRUD de Zoológico
Este proyecto es una aplicación de consola en Kotlin para gestionar zoológicos y sus animales utilizando operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

Estructura del Proyecto
El proyecto está organizado en los siguientes archivos principales:

Animal.kt: Define la clase Animal.
Zoologico.kt: Define la clase Zoologico.
AnimalCRUD.kt: Contiene las operaciones CRUD para la entidad Animal.
ZooCRUD.kt: Contiene las operaciones CRUD para la entidad Zoologico, integrando la gestión de los animales en cada zoológico.
main.kt: Contiene la interfaz de usuario en consola para interactuar con el sistema.
Uso
Menú Principal
Gestión de Zoológicos
Gestión de Animales
Salir
Menú de Gestión de Zoológicos
Crear Zoológico
Leer Zoológicos
Actualizar Zoológico
Eliminar Zoológico
Añadir Animal a Zoológico
Eliminar Animal de Zoológico
Actualizar Animal en Zoológico
Volver al Menú Principal
Menú de Gestión de Animales
Crear Animal
Leer Animales
Actualizar Animal
Eliminar Animal
Volver al Menú Principal

Crear un Zoológico
Selecciona la opción "Gestión de Zoológicos" en el Menú Principal.
Selecciona "Crear Zoológico" e ingresa los datos solicitados (nombre, ubicación, fecha de fundación, capacidad máxima).
Añadir un Animal a un Zoológico
Selecciona la opción "Gestión de Zoológicos" en el Menú Principal.
Selecciona "Añadir Animal a Zoológico" e ingresa los datos solicitados (nombre del animal, especie, edad, fecha de ingreso, peso).
Leer los Zoológicos
Selecciona la opción "Gestión de Zoológicos" en el Menú Principal.
Selecciona "Leer Zoológicos" para ver una lista de los zoológicos registrados.
Notas
Los datos de los animales y los zoológicos se almacenan en archivos de texto (DB_Animals.txt y DB_Zoo.txt).
Asegúrate de que estos archivos existan en el directorio raíz del proyecto para evitar errores de lectura/escritura.
