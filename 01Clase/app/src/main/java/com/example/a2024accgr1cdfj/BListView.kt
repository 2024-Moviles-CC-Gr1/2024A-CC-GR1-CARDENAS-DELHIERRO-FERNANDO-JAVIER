package com.example.a2024accgr1cdfj

import android.content.DialogInterface
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class BListView : AppCompatActivity() {
    val arreglo = BBaseDatosMemoria.arregloBEntrenador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_blist_view)
        val listView = findViewById<ListView>(R.id.listView)
        val adaptador = ArrayAdapter(
            this, //contexto
            android.R.layout.simple_list_item_1, //
            arreglo
        )
        listView.adapter = adaptador
        adaptador.notifyDataSetChanged() //refresacar la pantalla

        val botonanadirListView = findViewById<Button>(
            R.id.btt_anadir_list_view
        )
        botonanadirListView.setOnClickListener{
            anadirEntrenador(adaptador)
        }
        registerForContextMenu(listView)
    }

    var posicionItemSeleccionado =-1
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ){
        super.onCreateContextMenu(menu,v,menuInfo)
        //lenamos opciones del menu
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        //obtener id
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val posicion = info.position
        posicionItemSeleccionado = posicion
    }

    override fun onContextItemSelected(
        item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.mi_editar -> {
                mostrarSnackbar("Editar $posicionItemSeleccionado")
                return true
            }
            R.id.mi_eliminar -> {
                mostrarSnackbar("Eliminar $posicionItemSeleccionado")
                abrirDialogo()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    fun abrirDialogo(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desea Eliminar")
        builder.setPositiveButton(
            "Aceptar",
            DialogInterface.OnClickListener{
                dialogInterface, i ->
                mostrarSnackbar("eliminar aceptado")
            }
        )

        builder.setNegativeButton("Cancelar",null)
        val opciones = arrayListOf<String>()
        val seleccionPrevia = booleanArrayOf(
            true,false,false
        )
        builder.setMultiChoiceItems(
            opciones, seleccionPrevia,
            { dialog, which, isChecked ->
                mostrarSnackbar("Dio clock en el item $which")
            }
        )
        val dialogo = builder.create()
        dialogo.show()

    }
    fun anadirEntrenador(adaptador:ArrayAdapter<BEntrenador>){
        arreglo.add(
            BEntrenador(4,"Glen","g@d.com")
        )
    }

    fun mostrarSnackbar(texto:String){
        val snack = Snackbar.make(
            findViewById(R.id.cl_clico_vida),
            texto,
            Snackbar.LENGTH_INDEFINITE
        )
        snack.show()
    }
}