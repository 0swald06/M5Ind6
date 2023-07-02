package com.example.m5ind6

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImagenAdapter(val imagen: List<Imagen>) : RecyclerView.Adapter<ImagenAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var vista=LayoutInflater.from(parent.context).inflate(R.layout.item_fragment,parent,false)
        return  ViewHolder(vista)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(imagen[position])

    }

    override fun getItemCount(): Int {
        return imagen.size
    }
    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        init {

        }

        fun bindItems(imagen: Imagen){



            itemView.setOnClickListener{
                var intent = Intent(itemView.context, VerImagen::class.java)

                intent.putExtra("nombre",imagen.titulo)
                intent.putExtra("descripcion",imagen.descripcion)
                intent.putExtra("url",imagen.url)
                itemView.context.startActivity(intent)

            }
            val nombre=itemView.findViewById<TextView>(R.id.item_nombre)
            nombre.text=imagen.titulo

            val descripcion=itemView.findViewById<TextView>(R.id.item_descripcion)
            descripcion.text=imagen.descripcion

            val imagen2=itemView.findViewById<ImageView>(R.id.item_imagen)
            Glide.with(itemView.context)
                .load(imagen.url)
                .into(imagen2)

        }
    }
}