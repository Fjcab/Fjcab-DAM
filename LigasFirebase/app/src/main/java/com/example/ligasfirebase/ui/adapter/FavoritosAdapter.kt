package com.example.ligasfirebase.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ligasfirebase.R
import com.example.ligasfirebase.db.model.Equipo
import com.google.android.material.button.MaterialButton

class FavoritosAdapter (val lista: ArrayList<Equipo>, val context: Context, val listener: OnFavoritoClickListener)
    : RecyclerView.Adapter<FavoritosAdapter.MyHolder>(){
        inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val imagen: ImageView = itemView.findViewById(R.id.imagenEquipo)
            val nombre: TextView = itemView.findViewById(R.id.nombreEquipo)
            val favoritos: MaterialButton = itemView.findViewById(R.id.btnFavoritos)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista =LayoutInflater.from(context).inflate(R.layout.item_equipo, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val equipo = lista[position]
        holder.nombre.text = equipo.strTeam
        Glide.with(context).load(equipo.strBadge).into(holder.imagen)
        holder.favoritos.setIconResource(R.drawable.favorito)
        holder.favoritos.setOnClickListener {
            listener.onEliminarFavorito(equipo, holder.adapterPosition)
        }
    }

    fun addEquipo(x: Equipo){
        lista.add(x)
        notifyItemInserted(lista.size-1)
    }

    fun eliminarEquipo(pos: Int) {
        lista.removeAt(pos)
        notifyItemRemoved(pos)
    }

    interface OnFavoritoClickListener {
        fun onEliminarFavorito(equipo: Equipo, posicion: Int)
    }
}