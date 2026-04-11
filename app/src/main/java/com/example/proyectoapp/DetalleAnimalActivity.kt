package com.example.proyectoapp

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleAnimalActivity : AppCompatActivity() {

    lateinit var nombre : TextView
    lateinit var imagen : ImageView
    lateinit var reproducirSonido : Button
    lateinit var reproducirVideo : Button
    lateinit var videoView: VideoView
    lateinit var volver : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_animal)

        //Conectar vistas del XML con el código
        nombre = findViewById(R.id.nombreAnimal)
        imagen = findViewById(R.id.imagenAnimal)
        reproducirSonido = findViewById(R.id.btnSonido)
        reproducirVideo = findViewById(R.id.btnVideo)
        videoView = findViewById(R.id.mostrarVideo)
        volver = findViewById(R.id.btnVolver)

        //Recuperar la posición del animal seleccionado en onbindViewHolder(AnimalAdapter)
        val position = intent.getIntExtra("position", 0)

        //Variable para reproducir el vídeo automáticamente desde ver vídeo
        val autoplayVideo = intent.getBooleanExtra("autoplayVideo", false)

        //Obtenemos la lista de animales del objeto
        val animal = AnimalRepository.listaAnimales[position]

        // Mostrar el nombre del animal en el TextView
        nombre.text = animal.nombre
        // Mostrar la imagen del animal en el ImageView
        imagen.setImageResource(animal.imagen)

        //Reproducir automáticamente el vídeo si se viene desde VideosActivity
        if (autoplayVideo) {
            val uri = Uri.parse("android.resource://$packageName/${animal.video}")
            videoView.setVideoURI(uri)
            videoView.start()
        }

        //Evento click al boton escuchar sonido
        reproducirSonido.setOnClickListener {

            Toast.makeText(this, "Reproduciendo sonido del animal", Toast.LENGTH_LONG).show()
            val mp = MediaPlayer.create(this,animal.sonido)
            mp.start()
        }

        // Evento click al botón reproducir vídeo
        reproducirVideo.setOnClickListener {

            Toast.makeText(this, "Reproduciendo vídeo del animal", Toast.LENGTH_SHORT).show()

            // Crear la URI del vídeo desde res/raw
            val uri = Uri.parse("android.resource://$packageName/${animal.video}")

            // Cargar el vídeo en el VideoView
            videoView.setVideoURI(uri)

            // Iniciar la reproducción
            videoView.start()
        }



        //Evento click al botón volver
        volver.setOnClickListener {

            //Mostrar mensaje en pantalla
            Toast.makeText(this, "Volviendo a la lista de animales", Toast.LENGTH_LONG).show()
            //Cerrar esta activity y volver a la anterior
            finish()
        }

    }
}