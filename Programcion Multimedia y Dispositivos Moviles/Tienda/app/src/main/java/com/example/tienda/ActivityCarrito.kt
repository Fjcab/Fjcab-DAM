package com.example.tienda

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.CarritoAdapter
import com.example.tienda.databinding.ActivityCarritoBinding
import com.example.tienda.model.Producto
import com.google.android.material.snackbar.Snackbar

class ActivityCarrito : AppCompatActivity(), CarritoAdapter.OnCarritoListener {
    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapterCarrito: CarritoAdapter
    private lateinit var carrito: ArrayList<Producto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        carrito = if (savedInstanceState != null) {
            savedInstanceState.getSerializable("carrito") as ArrayList<Producto>
        } else {
            intent.getSerializableExtra("carrito") as ArrayList<Producto>
        }
        instancias()
    }

    private fun instancias() {
        setSupportActionBar(binding.toolbarCarrito)
        adapterCarrito = CarritoAdapter(carrito, this, this)
        binding.recyclerCarrito.adapter = adapterCarrito
        if (resources.configuration.orientation == 1){
            binding.recyclerCarrito.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
        if (resources.configuration.orientation == 2){
            binding.recyclerCarrito.layoutManager =
                GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        }
        calcularTotal()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.carrito_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuConfirmar -> {
                val total = calcularTotal()
                val totalFormateado = String.format("%.2f", total)
                Snackbar.make(binding.root, getString(R.string.compra_realizada, totalFormateado), Snackbar.LENGTH_LONG).show()
            }
            R.id.menuVaciar -> {
                androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle(getString(R.string.vaciar_carrito))
                    .setMessage(getString(R.string.confirmar_vaciado))
                    .setPositiveButton(getString(R.string.si)) { dialog, _ ->
                        adapterCarrito.clearProductos()
                        carrito.clear()
                        calcularTotal()
                        Snackbar.make(binding.root, getString(R.string.carrito_vaciado), Snackbar.LENGTH_LONG).show()
                    }
                    .setNegativeButton(R.string.no) { dialog, which ->
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
            R.id.menuVolver -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("carrito", carrito)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
            R.id.menuSalir -> {
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun calcularTotal(): Double {
        val total = carrito.sumOf { it.price }
        val totalFormateado = String.format("%.2f", total)
        binding.textoTotal.text = binding.root.context.getString(R.string.mensaje_total, totalFormateado)
        return total
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("carrito", carrito)
    }

    override fun onCarritoUpdated(carrito: ArrayList<Producto>) {
        calcularTotal()
    }

}