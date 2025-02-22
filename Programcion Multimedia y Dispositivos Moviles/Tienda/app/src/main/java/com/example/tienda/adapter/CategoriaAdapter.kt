package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tienda.R
import com.example.tienda.model.Categoria


class CategoriaAdapter(var lista: ArrayList<Categoria>, var context: Context): BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Categoria {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vista: View = LayoutInflater.from(context).inflate(R.layout.spinner_categorias, parent, false)
        val categoria = lista[position]
        val texto: TextView = vista.findViewById(R.id.textoCategoria)
        texto.text = categoria.name
        return vista
    }

    fun addCategorias(x: Categoria) {
        lista.add(x)
        notifyDataSetChanged()

    }

}