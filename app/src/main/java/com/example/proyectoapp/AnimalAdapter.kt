package com.example.proyectoapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter encargado de mostrar la lista de animales en el RecyclerView
class AnimalAdapter(val listaAnimales: List<Animal>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    // ViewHolder que enlaza las vistas de cada item del RecyclerView
    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // ImageView donde se mostrará la imagen del animal
        val imagenAnimal: ImageView = view.findViewById(R.id.imagenAnimal)

        // TextView donde se mostrará el nombre del animal
        val descripcionAnimal: TextView = view.findViewById(R.id.descripcionAnimal)
    }

    // Devuelve el número total de elementos de la lista
    override fun getItemCount(): Int {
        return listaAnimales.size
    }

    // Asocia los datos de cada animal con las vistas del item correspondiente
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]

        // Mostrar el nombre del animal en el TextView
        holder.descripcionAnimal.text = animal.nombre

        // Mostrar la imagen del animal en el ImageView
        holder.imagenAnimal.setImageResource(animal.imagen)

        // Detectar el click del usuario sobre un animal de la lista
        holder.itemView.setOnClickListener {

            // Obtener el contexto desde la vista actual
            val context = holder.itemView.context

            // Crear un Intent para abrir la ficha de detalle del animal
            val intent = Intent(context, DetalleAnimalActivity::class.java)

            // Enviar la posición del animal seleccionado a la siguiente Activity
            intent.putExtra("position", position)

            // Iniciar la nueva Activity
            context.startActivity(intent)
        }
    }

    // Crea la vista de cada item del RecyclerView a partir del layout XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {

        // Obtener el LayoutInflater para convertir el XML en una vista
        val inflater = LayoutInflater.from(parent.context)

        // Inflar el layout item_animal.xml y convertirlo en una vista real
        val vista = inflater.inflate(R.layout.item_animal, parent, false)

        // Devolver el ViewHolder con la vista creada
        return AnimalViewHolder(vista)
    }
}