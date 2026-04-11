package com.example.proyectoapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AnimalesActivity : AppCompatActivity() {

    lateinit var volver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enlaza esta Activity con su layout XML
        setContentView(R.layout.activity_animales)

        // Obtener referencia al RecyclerView definido en el XML
        val recycler = findViewById<RecyclerView>(R.id.recyclerAnimales)

        // Definir cómo se van a mostrar los elementos (lista vertical)
        recycler.layoutManager = LinearLayoutManager(this)

        // Crear el Adapter pasándole la lista de animales
        // y asignarlo al RecyclerView para que pueda mostrar los datos
        recycler.adapter = AnimalAdapter(AnimalRepository.listaAnimales)

        //Crear variable del botón volver
        volver = findViewById(R.id.btnVolverAnimales)

        //regresar a la ventana de inicio de la aplicación
        volver.setOnClickListener {

            Toast.makeText(this, "Regresando a la ventana inicial", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}