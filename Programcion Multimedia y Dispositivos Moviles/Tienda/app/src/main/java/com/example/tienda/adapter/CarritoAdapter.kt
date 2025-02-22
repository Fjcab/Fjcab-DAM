package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.R

import com.example.tienda.model.Producto

class CarritoAdapter(val lista: ArrayList<Producto>, val context: Context, private val listener: OnCarritoListener)
    : RecyclerView.Adapter<CarritoAdapter.MyHolder>(){

    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var nombre: TextView = itemView.findViewById(R.id.nombreCarrito)
        var imagen: ImageView = itemView.findViewById(R.id.imagenCarrito)
        var precio: TextView = itemView.findViewById(R.id.precioCarrito)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.tarjeta_carrito, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val productos = lista[position]
        holder.nombre.text = productos.title
        Glide.with(context).load(productos.thumbnail).into(holder.imagen)
        holder.precio.text = productos.price.toString()
        holder.itemView.setOnLongClickListener {
            removeProductoAt(holder.adapterPosition)
            Toast.makeText(context, context.getString(R.string.producto_eliminado, productos.title), Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    fun clearProductos (){
        val size = lista.size
        lista.clear()
        notifyItemRangeRemoved(0, size)
    }

    fun removeProductoAt(position: Int) {
        lista.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, lista.size)
        listener.onCarritoUpdated(lista)
    }

    interface OnCarritoListener {
        fun onCarritoUpdated(carrito: ArrayList<Producto>)
    }

}