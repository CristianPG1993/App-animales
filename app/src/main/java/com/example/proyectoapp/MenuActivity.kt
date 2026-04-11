package com.example.proyectoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    //Definimos las variables que vamos a utilizar
    lateinit var verAnimales : Button
    lateinit var escucharSonidos : Button
    lateinit var verVideos : Button
    lateinit var volver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Enlaza el layout XML con esta Activity
        setContentView(R.layout.activity_menu)

        //Conectar botones del XML con el código
        verAnimales = findViewById(R.id.btnverAnimales)
        escucharSonidos = findViewById(R.id.btnescucharSonidos)
        verVideos = findViewById(R.id.btnverVideos)
        volver = findViewById(R.id.btnvolver)

        //Evento click al botón ver animales
        verAnimales.setOnClickListener {

            //Mostrar mensaje en pantalla
            Toast.makeText(this,"Entrando en el menú de los animales", Toast.LENGTH_LONG).show()
            //Navegación hacía la ventana de los animales
            val intent = Intent(this, AnimalesActivity::class.java)
            startActivity(intent)
        }

        // Evento click al botón escuchar sonidos
        escucharSonidos.setOnClickListener {

            Toast.makeText(this, "Entrando en sonidos", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SonidosActivity::class.java)
            startActivity(intent)
        }

        // Evento click al botón ver vídeos
        verVideos.setOnClickListener {

            Toast.makeText(this, "Entrando en vídeos", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, VideosActivity::class.java)
            startActivity(intent)
        }

        //Evento click al botón volver
        volver.setOnClickListener {

            //Mostrar mensaje en pantalla
            Toast.makeText(this, "Volviendo atrás", Toast.LENGTH_LONG).show()
            //Cerrar esta activity y volver a la anterior
            finish()
        }
    }
}