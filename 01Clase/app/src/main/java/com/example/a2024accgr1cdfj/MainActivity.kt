package com.example.a2024accgr1cdfj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.a2024accgr1cdfj.R.id.btn_ir_list_view

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bootonCicloVida = findViewById<Button>(R.id.btn_ciclo_vida1)
        bootonCicloVida
            .setOnClickListener{
                irActividad(ACicloVida::class.java)
            }

        val botonBListView = findViewById<Button>(R.id.btn_ir_list_view)
        botonBListView
            .setOnClickListener{
                irActividad(BListView::class.java)
            }


    }

    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}
