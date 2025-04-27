package com.example.ligasfirebase.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ligasfirebase.db.model.Liga
import androidx.recyclerview.widget.RecyclerView
import com.example.ligasfirebase.R

class LigasAdapter (val lista: ArrayList<Liga>, val context: Context, var listener: OnLigaListener): RecyclerView.Adapter<LigasAdapter.MyHolder>() {
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nombre: TextView = itemView.findViewById(R.id.nombreLiga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigasAdapter.MyHolder {
        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_liga, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: LigasAdapter.MyHolder, position: Int) {
        val liga: Liga = lista[position]
        holder.nombre.text = liga.strLeague

        holder.itemView.setOnClickListener {
            listener.onLigaSelected(liga)
        }
    }

    fun addLiga(liga: Liga){
        this.lista.add(liga)
        notifyItemInserted(lista.size-1)
    }

    interface OnLigaListener{
        fun onLigaSelected(liga: Liga)
    }
}