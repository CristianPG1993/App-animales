package com.example.proyectoapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SonidosActivity : AppCompatActivity() {

    lateinit var volver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sonidos)

        volver = findViewById(R.id.btnVolverAtras)



        // Obtener referencia al RecyclerView definido en el XML
        val recycler = findViewById<RecyclerView>(R.id.recyclerSonidos)

        // Definir cómo se van a mostrar los elementos (lista vertical)
        recycler.layoutManager = LinearLayoutManager(this)

        // Crear el Adapter pasándole la lista de animales
        // y asignarlo al RecyclerView para que pueda mostrar los datos
        recycler.adapter = SonidoAdapter(AnimalRepository.listaAnimales)

        //regresar a la ventana de inicio de la aplicación
        volver.setOnClickListener {

            Toast.makeText(this, "Volviendo al menú", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}