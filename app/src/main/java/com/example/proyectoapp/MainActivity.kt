package com.example.proyectoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Definimos las variables que vamos a utilizar
    lateinit var salir: Button
    lateinit var entrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Enlaza el layout XML con esta Activity
        setContentView(R.layout.activity_main)

        //Conectar botones del XML con el código
        salir = findViewById(R.id.btnSalir)
        entrar = findViewById(R.id.btnEntrar)

        //Evento click al botón salir
        salir.setOnClickListener {

            //Mostrar mensaje en pantalla
            Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_LONG).show()
            //Cerrar la Activity actual
            finish()
        }

        //Evento click al botón entrar
        entrar.setOnClickListener {

            //Mostrar mensaje en pantalla
            Toast.makeText(this, "Bienvenido a la APP", Toast.LENGTH_LONG).show()

            //Navegación hacía la ventana Menú
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }


    }
}