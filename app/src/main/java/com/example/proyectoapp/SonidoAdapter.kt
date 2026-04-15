package com.example.proyectoapp

import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoapp.AnimalAdapter.AnimalViewHolder

class SonidoAdapter(val listaAnimales: List<Animal>) : RecyclerView.Adapter<SonidoAdapter.SonidoViewHolder>(){

    // MediaPlayer para gestionar la reproducción de sonido
    var mediaPlayer: MediaPlayer? = null

    class SonidoViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val imagenAnimal : ImageView = view.findViewById(R.id.imagenAnimal)
        val nombreAnimal : TextView = view.findViewById(R.id.descripcionAnimal)

    }

    override fun getItemCount(): Int {
        return listaAnimales.size
    }

    // Libera los recursos del reproductor de audio
    fun liberarSonido() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    //Obtiene el animal de la lista
    override fun onBindViewHolder(holder: SonidoViewHolder, position: Int) {
        val animal = listaAnimales[position]

        holder.nombreAnimal.text = animal.nombre
        holder.imagenAnimal.setImageResource(animal.imagen)

        //Click del usuario al animal
        holder.itemView.setOnClickListener {

            val context = holder.itemView.context

            // Liberar sonido anterior si existe
            mediaPlayer?.release()

            // Crear nuevo MediaPlayer con el sonido del animal
            mediaPlayer = MediaPlayer.create(context, animal.sonido)

            // Reproducir sonido
            mediaPlayer?.start()
        }
    }

    // Crea la vista de cada item del RecyclerView a partir del layout XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SonidoViewHolder {
        // Obtiene el LayoutInflater para convertir el XML en una vista
        val inflater = LayoutInflater.from(parent.context)
        // Infla el layout item_animal.xml y lo convierte en una vista
        val vista = inflater.inflate(R.layout.item_animal, parent, false)

        return SonidoViewHolder(vista)
    }
}