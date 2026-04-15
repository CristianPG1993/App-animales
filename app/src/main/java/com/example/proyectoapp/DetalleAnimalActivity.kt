package com.example.proyectoapp

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class DetalleAnimalActivity : AppCompatActivity() {

    // Variables que representan las vistas del XML
    lateinit var nombre : TextView
    lateinit var imagen : ImageView
    lateinit var reproducirSonido : Button
    lateinit var reproducirVideo : Button
    lateinit var videoView: VideoView
    lateinit var volver : Button

    // MediaPlayer para gestionar la reproducción de audio
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enlaza el layout XML con esta Activity
        setContentView(R.layout.activity_detalle_animal)

        // Conectar vistas del XML con el código
        nombre = findViewById(R.id.nombreAnimal)
        imagen = findViewById(R.id.imagenAnimal)
        reproducirSonido = findViewById(R.id.btnSonido)
        reproducirVideo = findViewById(R.id.btnVideo)
        videoView = findViewById(R.id.mostrarVideo)
        volver = findViewById(R.id.btnVolver)

        // Recuperar la posición del animal enviada mediante Intent
        val position = intent.getIntExtra("position", 0)

        // Indica si el vídeo debe reproducirse automáticamente
        val autoplayVideo = intent.getBooleanExtra("autoplayVideo", false)

        // Obtener el animal seleccionado desde el repositorio
        val animal = AnimalRepository.listaAnimales[position]

        // Mostrar el nombre del animal en el TextView
        nombre.text = animal.nombre

        // Mostrar la imagen del animal en el ImageView
        imagen.setImageResource(animal.imagen)

        // Reproducir automáticamente el vídeo si se viene desde VideosActivity
        if (autoplayVideo) {
            val uri = Uri.parse("android.resource://$packageName/${animal.video}")
            videoView.setVideoURI(uri)
            videoView.start()
        }

        // Evento click al botón escuchar sonido
        reproducirSonido.setOnClickListener {

            // Mostrar mensaje al usuario
            Toast.makeText(this, "Reproduciendo sonido del animal", Toast.LENGTH_SHORT).show()

            // Liberar cualquier audio anterior antes de reproducir uno nuevo
            mediaPlayer?.release()

            // Crear un nuevo MediaPlayer con el sonido del animal
            mediaPlayer = MediaPlayer.create(this, animal.sonido)

            // Iniciar la reproducción del sonido
            mediaPlayer?.start()
        }

        // Evento click al botón reproducir vídeo
        reproducirVideo.setOnClickListener {

            // Mostrar mensaje al usuario
            Toast.makeText(this, "Reproduciendo vídeo del animal", Toast.LENGTH_SHORT).show()

            // Crear la URI del vídeo almacenado en res/raw
            val uri = Uri.parse("android.resource://$packageName/${animal.video}")

            // Cargar el vídeo en el VideoView
            videoView.setVideoURI(uri)

            // Iniciar la reproducción del vídeo
            videoView.start()
        }

        // Evento click al botón volver
        volver.setOnClickListener {

            // Mostrar mensaje en pantalla
            Toast.makeText(this, "Volviendo a la lista de animales", Toast.LENGTH_SHORT).show()

            // Cerrar esta Activity y volver a la anterior
            finish()
        }
    }

    // Mé_todo que se ejecuta cuando la Activity deja de ser visible
    override fun onStop() {
        super.onStop()

        // Liberar recursos del MediaPlayer para evitar fugas de memoria
        mediaPlayer?.release()
        mediaPlayer = null
    }
}