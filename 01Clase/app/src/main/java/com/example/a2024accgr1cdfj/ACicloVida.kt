package com.example.a2024accgr1cdfj

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class ACicloVida : AppCompatActivity() {
    var textoGlobal = ""

    fun mostrarSnackbar(texto: String) {
        textoGlobal += texto
        val snack = Snackbar.make(
            findViewById(R.id.cl_clico_vida),
            textoGlobal,
            Snackbar.LENGTH_INDEFINITE
        )
        snack.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aciclo_vida)
        mostrarSnackbar("OnCreate")
    }

    override fun onStart() {
        super.onStart()
        mostrarSnackbar("OnStart")
    }

    override fun onResume() {
        super.onResume()
        mostrarSnackbar("onResume")
    }

    override fun onRestart() {
        super.onRestart()
        mostrarSnackbar("onResart")
    }

    override fun onPause() {
        super.onPause()
        mostrarSnackbar("onPause")
    }

    override fun onStop() {
        super.onStop()
        mostrarSnackbar("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        mostrarSnackbar("onDestroy")
    }

    //Clase 13-06-2024

    override fun onSaveInstanceState (outState: Bundle) {
        outState
            .run {
                //guardar las primitivas
                putString("varibaleTextoGuardado", textoGlobal)
            }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        //recuperar las variables
        val textoRecuperadoDeVariable: String? =
            savedInstanceState.getString("varibaleTextoGuardado")
        if (textoRecuperadoDeVariable != null) {
            mostrarSnackbar(textoRecuperadoDeVariable)
            textoGlobal = textoRecuperadoDeVariable
        }
    }

}