package com.example.adivinacion

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.adivinacion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.LENGTH_SHORT

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var texto: String;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        texto = savedInstanceState?.getString("texto") ?: ""
        binding.btn.setOnClickListener{
            texto = binding.nombre.text.toString().trim()
            if(texto.isNotEmpty()){
                Snackbar.make(binding.root, "Perfecto ${texto}, ¿Quieres empezar?", Snackbar.LENGTH_LONG)
                    .setAction("OK") {
                        val intent = Intent(applicationContext, JuegoActivity::class.java)
                        val bundle: Bundle = Bundle()
                        bundle.putString("nombre", texto)
                        intent.putExtra("datos", bundle)
                        startActivity(intent)
                    }.also { snackbar ->
                        val snackbarView = snackbar.view
                        val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                        params.gravity = Gravity.CENTER
                        snackbarView.layoutParams = params
                    }.show()
            }else{
                Snackbar.make(binding.root, "Por favor introduce nombre", LENGTH_SHORT).
                also { snackbar ->
                    val snackbarView = snackbar.view
                    val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                    params.gravity = Gravity.CENTER
                    snackbarView.layoutParams = params
                }.show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("texto", texto)

    }

}