package com.example.a2024accgr1cdfj

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.GoogleMap

class GGoogleMapsActivit : AppCompatActivity(){
    private  lateinit var maps: GoogleMap
    var permisos = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ggoogle_maps)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun solicitarPermisos(){
            val contexto = this.applicationContext
            val nombrePermisosFine = android.Manifest.permission.ACCESS_FINE_LOCATION
            val nombrePermissionCoarse = android.Manifest.permission.ACCESS_COARSE_LOCATION
            val permisoFine = ContextCompat.checkSelfPermission(contexto, nombrePermisosFine)
            val permisoCoarse = ContextCompat.checkSelfPermission(contexto, nombrePermissionCoarse)
            val tienePermisos = permisoFine == PackageManager.PERMISSION_GRANTED &&
                    permisoCoarse == PackageManager.PERMISSION_GRANTED
            if(tienePermisos){
                permisos = true
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(nombrePermisosFine, nombrePermissionCoarse), 1
                )
            }
            }
    }


}