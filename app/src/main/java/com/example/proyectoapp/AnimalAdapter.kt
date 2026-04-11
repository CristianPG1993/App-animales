package com.example.proyectoapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(val listaAnimales: List<Animal>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imagenAnimal : ImageView = view.findViewById(R.id.imagenAnimal)
        val descripcionAnimal : TextView = view.findViewById(R.id.descripcionAnimal)


    }

    //Obtener el tamanio de la lista
    override fun getItemCount(): Int{

        return listaAnimales.size
    }

    //Obtiene el animal de la lista
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]

        holder.descripcionAnimal.text = animal.nombre
        holder.imagenAnimal.setImageResource(animal.imagen)

        //Click del usuario al animal
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context,DetalleAnimalActivity::class.java)

            intent.putExtra("position", position)
            context.startActivity(intent)
        }

    }

    // Crea la vista de cada item del RecyclerView a partir del layout XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        // Obtiene el LayoutInflater para convertir el XML en una vista
        val inflater = LayoutInflater.from(parent.context)
        // Infla el layout item_animal.xml y lo convierte en una vista
        val vista = inflater.inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(vista)
    }
}