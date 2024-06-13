package com.example.a2024accgr1cdfj

class BBaseDatosMemoria {
    companion object{

        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador(1, "Karla", "k@.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2,"Fercho","f@com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3,"Paco","p@com")
                )


        }
    }
}