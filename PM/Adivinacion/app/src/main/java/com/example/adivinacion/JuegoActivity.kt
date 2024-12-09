package com.example.adivinacion

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.adivinacion.databinding.ActivityJuegoBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class JuegoActivity : AppCompatActivity(), OnClickListener, OnTouchListener {
    private lateinit var binding: ActivityJuegoBinding
    private lateinit var bundleRecuperado: Bundle
    private lateinit var nombre: String
    private var ultimaCarta: Int = 0
    private var contador = 0
    private val cartas = arrayOf(
        R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4,
        R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8,
        R.drawable.c9, R.drawable.c10, R.drawable.c11, R.drawable.c12,
        R.drawable.c13
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bundleRecuperado = intent.extras?.getBundle("datos") ?:Bundle()
        nombre = savedInstanceState?.getString("nombre") ?: bundleRecuperado.getString("nombre") ?:"Jugador"
        ultimaCarta = savedInstanceState?.getInt("ultimaCarta", 0) ?: 0
        contador = savedInstanceState?.getInt("contador", 0) ?: 0

        binding.up.setOnClickListener(this)
        binding.up.setOnTouchListener(this)
        binding.down.setOnClickListener(this)
        binding.down.setOnTouchListener(this)

        Snackbar.make(binding.root, "Bienvenido ${nombre}", Snackbar.LENGTH_INDEFINITE)
            .setAction("OK") {
               ultimaCarta=cartaAleatoria()
            }.also { snackbar ->
                val snackbarView = snackbar.view
                val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                params.gravity = Gravity.CENTER
                snackbarView.layoutParams = params
            }
            .show()
    }

    private fun cartaAleatoria(): Int {
        val nuevaCarta = Random.nextInt(1, 14)
        binding.carta.setImageResource(cartas[nuevaCarta - 1])
        return nuevaCarta
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.up.id->{
                if(ultimaCarta==0){
                    Snackbar.make(binding.root, "Bienvenido ${nombre}", Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK") {
                            ultimaCarta = cartaAleatoria()
                        }.also { snackbar ->
                            val snackbarView = snackbar.view
                            val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                            params.gravity = Gravity.CENTER
                            snackbarView.layoutParams = params
                        }
                        .show()
                }else{
                    val nuevaCarta = cartaAleatoria()
                    if (nuevaCarta == ultimaCarta){
                        Snackbar.make(
                            binding.root,
                            "Empate.",
                            Snackbar.LENGTH_SHORT
                        ).also { snackbar ->
                            val snackbarView = snackbar.view
                            val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                            params.gravity = Gravity.CENTER
                            snackbarView.layoutParams = params
                        }.show()
                    }
                    if (nuevaCarta > ultimaCarta){
                        ultimaCarta = nuevaCarta
                        contador ++
                    }else{
                        Snackbar.make(binding.root, "Tu puntuacion es de ${contador} puntos ${nombre}.",Snackbar.LENGTH_SHORT)
                            .also { snackbar ->
                                val snackbarView = snackbar.view
                                val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                                params.gravity = Gravity.CENTER
                                snackbarView.layoutParams = params
                            }.show()
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
            binding.down.id->{
                if(ultimaCarta==0){
                    Snackbar.make(binding.root, "Bienvenido ${nombre}", Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK") {
                            ultimaCarta = cartaAleatoria()
                        }.also { snackbar ->
                            val snackbarView = snackbar.view
                            val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                            params.gravity = Gravity.CENTER
                            snackbarView.layoutParams = params
                        }
                        .show()
                }else {
                    val nuevaCarta = cartaAleatoria()
                     if (nuevaCarta == ultimaCarta){
                         Snackbar.make(
                             binding.root,
                             "Empate.",
                             Snackbar.LENGTH_SHORT
                         ).also { snackbar ->
                             val snackbarView = snackbar.view
                             val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                             params.gravity = Gravity.CENTER
                             snackbarView.layoutParams = params
                         }.show()
                     }
                    if (nuevaCarta < ultimaCarta) {
                        ultimaCarta = nuevaCarta
                        contador ++
                    } else {
                        Snackbar.make(
                            binding.root,
                            "Tu puntuacion es de ${contador} puntos ${nombre}.",
                            Snackbar.LENGTH_SHORT
                        ).also { snackbar ->
                            val snackbarView = snackbar.view
                            val params = snackbarView.layoutParams as FrameLayout.LayoutParams
                            params.gravity = Gravity.CENTER
                            snackbarView.layoutParams = params
                            }.show()
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (v == null || event == null) return false
        when(v.id){
            binding.up.id->{
                when(event.action){
                    MotionEvent.ACTION_DOWN ->{
                        binding.up.setImageResource(R.drawable.up_press1)
                    }
                    MotionEvent.ACTION_UP ->{
                        binding.up.setImageResource(R.drawable.up1)
                    }

                }

            }
            binding.down.id->{
                when(event.action){
                    MotionEvent.ACTION_DOWN ->{
                        binding.down.setImageResource(R.drawable.down_press1)
                    }
                    MotionEvent.ACTION_UP ->{
                        binding.down.setImageResource(R.drawable.down1)
                    }

                }
            }
        }
        return false
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("ultimaCarta", ultimaCarta)
        outState.putInt("contador", contador)
        outState.putString("nombre", nombre)
    }
}