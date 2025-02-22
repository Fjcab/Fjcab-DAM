package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.MainActivity
import com.example.tienda.R
import com.example.tienda.model.Producto

class ProductosAdapter (val lista: ArrayList<Producto>, val context: Context, val carrito: ArrayList<Producto>)
    : RecyclerView.Adapter<ProductosAdapter.MyHolder>() {

    inner class MyHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val toolbar: Toolbar = itemView.findViewById(R.id.toolbarCard)
        val imagen: ImageView = itemView.findViewById(R.id.imagenProducto)
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        val precio: TextView = itemView.findViewById(R.id.precio)
        val btnComprar: Button = itemView.findViewById(R.id.btnComprar)

        init {
            toolbar.inflateMenu(R.menu.tarjeta_menu)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.tarjeta_productos, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val productos = lista[position]
        holder.toolbar.title = productos.title
        Glide.with(context).load(productos.thumbnail).into(holder.imagen)
        holder.nombre.text = productos.title
        holder.precio.text = productos.price.toString()
        holder.toolbar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.menuComprar ->{
                    carrito.add(productos)
                    Toast.makeText(context, context.getString(R.string.producto_insertado, productos.title), Toast.LENGTH_SHORT).show()
                    (context as MainActivity).actualizarIconoCarrito()
                }
            }
            return@setOnMenuItemClickListener true
        }
        holder.btnComprar.setOnClickListener {
            carrito.add(productos)
            Toast.makeText(context, context.getString(R.string.producto_insertado, productos.title), Toast.LENGTH_SHORT).show()
            (context as MainActivity).actualizarIconoCarrito()
        }
    }

    fun addProductos (x: Producto){
        lista.add(x)
        notifyItemInserted(lista.size-1)
    }
    fun clearProductos (){
        val size = lista.size
        lista.clear()
        notifyItemRangeRemoved(0, size)
    }

}
