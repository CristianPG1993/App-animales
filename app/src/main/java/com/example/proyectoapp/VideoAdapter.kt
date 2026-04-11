package com.example.proyectoapp

import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class VideoAdapter (val listaAnimales : List<Animal>): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){

    class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val imagenAnimal : ImageView = view.findViewById(R.id.imagenAnimal)
        val nombreAnimal : TextView = view.findViewById(R.id.descripcionAnimal)
    }

    override fun getItemCount(): Int {
        return listaAnimales.size
    }

    //Obtiene el animal de la lista
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val animal = listaAnimales[position]

        holder.nombreAnimal.text = animal.nombre
        holder.imagenAnimal.setImageResource(animal.imagen)

        //Click del usuario al animal
        holder.itemView.setOnClickListener {

            val context = holder.itemView.context
            val intent = Intent(context, DetalleAnimalActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("autoplayVideo", true)
            context.startActivity(intent)
        }
    }

    // Crea la vista de cada item del RecyclerView a partir del layout XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        // Obtiene el LayoutInflater para convertir el XML en una vista
        val inflater = LayoutInflater.from(parent.context)
        // Infla el layout item_animal.xml y lo convierte en una vista
        val vista = inflater.inflate(R.layout.item_animal, parent, false)

        return VideoViewHolder(vista)
    }
}