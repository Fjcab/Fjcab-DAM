package com.example.tienda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.tienda.adapter.CategoriaAdapter
import com.example.tienda.adapter.ProductosAdapter
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.model.Categoria
import com.example.tienda.model.Producto
import com.google.gson.Gson
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterCategorias: CategoriaAdapter
    private lateinit var adapterProductos: ProductosAdapter
    private lateinit var listaCategorias: ArrayList<Categoria>
    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var carrito: ArrayList<Producto>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carrito = if (intent.hasExtra("carrito")) {
            val recibido = intent.getSerializableExtra("carrito") as ArrayList<Producto>
            recibido
        } else {
            Log.d("MainActivity", "No se recibió carrito, se inicializa vacío.")
            ArrayList()
        }

        instancias()
        cargarCategorias()
    }
    private fun instancias(){
        setSupportActionBar(binding.toolbar)
        listaCategorias = ArrayList()
        adapterCategorias = CategoriaAdapter(listaCategorias, this)
        binding.spinner.adapter = adapterCategorias

        listaProductos = ArrayList()
        adapterProductos = ProductosAdapter(listaProductos, this, carrito)
        binding.recyclerProductos.adapter = adapterProductos
        if (resources.configuration.orientation == 1){
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
        if (resources.configuration.orientation == 2){
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val menuItem = menu?.findItem(R.id.menuComprar)
        menuItem?.icon = if (carrito.size > 0) {
            resources.getDrawable(R.drawable.shopping_full, null)
        } else {
            resources.getDrawable(R.drawable.shopping_cart, null)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuComprar -> {
                val intent = Intent(this, ActivityCarrito::class.java)
                intent.putExtra("carrito", carrito)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
            R.id.menuSalir -> {
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun actualizarIconoCarrito() {
        invalidateOptionsMenu()
    }

    fun cargarCategorias() {
        val urlCategorias ="https://dummyjson.com/products/categories"
        val peticion: JsonArrayRequest = JsonArrayRequest(Request.Method.GET, urlCategorias, null,{
            listaCategorias.clear()
            listaCategorias.add(Categoria(binding.root.context.getString(R.string.categoria_ninguno)))
            val gson = Gson()
            val categorias = gson.fromJson(it.toString(), Array<Categoria>::class.java).toList()
            for (categoria in categorias) {
                adapterCategorias.addCategorias(categoria)
            }
            acciones()

        },{ error ->
            error.printStackTrace()
        })
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    private fun acciones() {
        binding.spinner.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val categoriaSeleccionada = adapterCategorias.getItem(position).slug
                if (categoriaSeleccionada == binding.root.context.getString(R.string.categoria_ninguno)) {
               val url ="https://dummyjson.com/products"
                cargarProductos(url)
            }else{
                val url ="https://dummyjson.com/products/category/${categoriaSeleccionada}"
                cargarProductos(url)
            }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                val url ="https://dummyjson.com/products"
                cargarProductos(url)
            }
        }
    }

    fun cargarProductos(url: String) {
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            adapterProductos.clearProductos()
            val array: JSONArray = it.getJSONArray("products")
            val gson = Gson()
            for (i in 0..array.length() - 1) {
                val productoJSON = array.getJSONObject(i)
                val producto = gson.fromJson(productoJSON.toString(), Producto::class.java)
                adapterProductos.addProductos(producto)
            }

        }, { error ->
            error.printStackTrace()
        })
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("carrito", carrito)
        outState.putSerializable("listaCategorias", listaCategorias)
        outState.putSerializable("listaProductos", listaProductos)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        carrito = savedInstanceState.getSerializable("carrito") as ArrayList<Producto>
        listaCategorias = savedInstanceState.getSerializable("listaCategorias") as ArrayList<Categoria>
        listaProductos = savedInstanceState.getSerializable("listaProductos") as ArrayList<Producto>

        adapterCategorias = CategoriaAdapter(listaCategorias, this)
        binding.spinner.adapter = adapterCategorias

        adapterProductos = ProductosAdapter(listaProductos, this, carrito)
        binding.recyclerProductos.adapter = adapterProductos
    }

}