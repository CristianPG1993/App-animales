package com.example.proyectoapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SonidosActivity : AppCompatActivity() {

    lateinit var volver : Button

    // Crear el Adapter pasándole la lista de animales
    val adapter = SonidoAdapter(AnimalRepository.listaAnimales)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sonidos)

        volver = findViewById(R.id.btnVolverAtras)



        // Obtener referencia al RecyclerView definido en el XML
        val recycler = findViewById<RecyclerView>(R.id.recyclerSonidos)

        // Definir cómo se van a mostrar los elementos (lista vertical)
        recycler.layoutManager = LinearLayoutManager(this)

        // Asignar el adaptador al RecyclerView
        recycler.adapter = adapter

        //regresar a la ventana de inicio de la aplicación
        volver.setOnClickListener {

            Toast.makeText(this, "Volviendo al menú", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    // Mé_todo que se ejecuta cuando la Activity deja de ser visible (por ejemplo, al pulsar el botón volver)
    override fun onStop() {
        super.onStop()

        //Detener y liberar cualquier sonido en reproducción
        adapter.liberarSonido()
    }
}