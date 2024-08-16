import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import animal.Animal
import java.time.LocalDate

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "zoologico.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createZoologicoTable = """
            CREATE TABLE Zoologico (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                locate TEXT,
                dateFundation TEXT,
                capacityMax INTEGER
            )
        """.trimIndent()
        db.execSQL(createZoologicoTable)

        val createAnimalTable = """
            CREATE TABLE Animal (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                specie TEXT,
                age INTEGER,
                dateInput TEXT,
                weight REAL,
                placeOfOrigin TEXT,
                zoologicoId INTEGER,
                FOREIGN KEY(zoologicoId) REFERENCES Zoologico(id)
            )
        """.trimIndent()
        db.execSQL(createAnimalTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Animal")
        db.execSQL("DROP TABLE IF EXISTS Zoologico")
        onCreate(db)
    }

    // Métodos CRUD para Zoologico
    fun addZoologico(zoologico: zoo): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", zoologico.name)
            put("locate", zoologico.locate)
            put("dateFundation", zoologico.dateFundation.toString())
            put("capacityMax", zoologico.capacityMax)
        }
        return db.insert("Zoologico", null, values)
    }

    fun getAllZoologicos(): List<zoo> {
        val db = readableDatabase
        val cursor = db.query("Zoologico", null, null, null, null, null, null)
        val zoologicos = mutableListOf<zoo>()

        while (cursor.moveToNext()) {
            val idIndex = cursor.getColumnIndex("id")
            val nameIndex = cursor.getColumnIndex("name")
            val locateIndex = cursor.getColumnIndex("locate")
            val dateFundationIndex = cursor.getColumnIndex("dateFundation")
            val capacityMaxIndex = cursor.getColumnIndex("capacityMax")

            if (idIndex == -1 || nameIndex == -1 || locateIndex == -1 || dateFundationIndex == -1 || capacityMaxIndex == -1) {
                // Manejar el error de columna no encontrada
                Log.e("DatabaseError", "Error: columna no encontrada")
                continue
            }

            val id = cursor.getInt(idIndex)
            val name = cursor.getString(nameIndex)
            val locate = cursor.getString(locateIndex)
            val dateFundation = LocalDate.parse(cursor.getString(dateFundationIndex))
            val capacityMax = cursor.getInt(capacityMaxIndex)

            val zoologico = zoo(name, locate, dateFundation, capacityMax)
            zoologicos.add(zoologico)
        }
        cursor.close()
        return zoologicos
    }


    // Métodos CRUD para Animal
    fun addAnimal(animal: Animal, zoologicoId: Int): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", animal.name)
            put("specie", animal.specie)
            put("age", animal.age)
            put("dateInput", animal.dateInput.toString())
            put("weight", animal.weight)
            put("placeOfOrigin", animal.placeOfOrigin)
            put("zoologicoId", zoologicoId)
        }
        return db.insert("Animal", null, values)
    }

    fun getAnimalsByZoologico(zoologicoId: Int): List<Animal> {
        val db = readableDatabase
        val cursor = db.query("Animal", null, "zoologicoId = ?", arrayOf(zoologicoId.toString()), null, null, null)
        val animals = mutableListOf<Animal>()
        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val specie = cursor.getString(cursor.getColumnIndex("specie"))
            val age = cursor.getInt(cursor.getColumnIndex("age"))
            val dateInput = LocalDate.parse(cursor.getString(cursor.getColumnIndex("dateInput")))
            val weight = cursor.getDouble(cursor.getColumnIndex("weight"))
            val placeOfOrigin = cursor.getString(cursor.getColumnIndex("placeOfOrigin"))

            animals.add(Animal(name, specie, age, dateInput, weight, placeOfOrigin))
        }
        cursor.close()
        return animals
    }
}
