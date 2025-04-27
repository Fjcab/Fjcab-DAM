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

class EquiposAdapter (val lista: ArrayList<Equipo>, val context: Context, val listener: OnEquipoListener, var favoritos: List<Equipo> = emptyList())
    : RecyclerView.Adapter<EquiposAdapter.MyHolder>(){
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
        val esFavorito = favoritos.any { it.strTeam == equipo.strTeam }

        holder.favoritos.setIconResource(
            if (esFavorito) R.drawable.favorito else R.drawable.estrella
        )

        holder.favoritos.setOnClickListener{
            listener.onEquipoSelected(equipo, holder.adapterPosition)
        }
    }

    fun actualizarFavoritos(nuevos: List<Equipo>) {
        favoritos = nuevos
    }

    fun addEquipo(x: Equipo){
        lista.add(x)
        notifyItemInserted(lista.size-1)
    }

    interface OnEquipoListener {
        fun onEquipoSelected(equipo: Equipo, position: Int)
    }
}