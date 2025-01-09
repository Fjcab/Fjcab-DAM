package com.example.imc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySecondBinding
    private lateinit var altura: String
    private lateinit var peso: String
    private lateinit var genero: String
    private lateinit var imc: String
    private lateinit var estado: String
    private var iconos: Int = 0
    private lateinit var bundleRecuperado: Bundle
    private val icono = arrayOf(
        R.drawable.estado1, R.drawable.estado2, R.drawable.estado3,
        R.drawable.estado4, R.drawable.estado5, R.drawable.estado6,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bundleRecuperado = intent.extras?.getBundle("datos") ?:Bundle()
        altura = savedInstanceState?.getString("altura", "") ?: bundleRecuperado.getString("altura") ?: ""
        peso = savedInstanceState?.getString("peso", "") ?: bundleRecuperado.getString("peso") ?: ""
        genero = savedInstanceState?.getString("genero", "") ?: bundleRecuperado.getString("genero") ?: ""
        imc = savedInstanceState?.getString("imc", "") ?: bundleRecuperado.getString("imc") ?: ""
        estado = savedInstanceState?.getString("estado", "") ?: bundleRecuperado.getString("estado") ?: ""
        iconos = savedInstanceState?.getInt("iconos", 0) ?: bundleRecuperado.getInt("iconos")

        binding.altura.setText(altura)
        binding.peso.setText(peso)
        when(genero){
            "Masculino"-> binding.masculino.isChecked = true
            "Femenino"-> binding.femenino.isChecked = true
        }
        binding.imc.text = imc
        binding.estado.text = estado
        binding.icono.setImageResource(icono[iconos])

        binding.btnCalcular.setOnClickListener {
            altura = binding.altura.text.toString()
            peso = binding.peso.text.toString()

            if(altura.isEmpty() || peso.isEmpty()){
                Snackbar.make(binding.root, "Introduce la altura, el peso.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val genSeleccionado = binding.genero.checkedRadioButtonId
            if (genSeleccionado !=-1){
                when(genSeleccionado){
                    binding.masculino.id-> genero = binding.masculino.text.toString()
                    binding.femenino.id-> genero = binding.femenino.text.toString()
                }
            }else{
                Snackbar.make(binding.root, "Selecciona el genero.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            imc = (peso.toDouble() / (altura.toDouble() * altura.toDouble()))
                .toBigDecimal().setScale(2,java.math.RoundingMode.HALF_EVEN).toString()
            if(genero=="Masculino"){
                estado = tipoMasculino(imc.toDouble())
            }
            if(genero=="Femenino"){
                estado = tipoFemenino(imc.toDouble())
            }
            val iconos = icono(estado)
            binding.imc.text = imc
            binding.estado.text = estado
            binding.icono.setImageResource(icono[iconos])
        }
    }

    fun tipoMasculino(imc: Double): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.99 -> "Peso normal"
            imc in 25.0..29.99 -> "Sobrepeso"
            imc in 30.0..34.99 -> "Obesidad I"
            imc in 35.0..39.99 -> "Obesidad II"
            else -> "Obesidad III"
        }
    }
    fun tipoFemenino(imc: Double): String {
        return when {
            imc < 16.5 -> "Bajo peso"
            imc in 16.5..22.99 -> "Peso normal"
            imc in 23.0..25.99 -> "Sobrepeso"
            imc in 26.0..30.99 -> "Obesidad I"
            imc in 31.0..33.99 -> "Obesidad II"
            else -> "Obesidad III"
        }
    }
    fun icono(estado: String): Int {
        return when (estado) {
            "Bajo peso" -> 0
            "Peso normal" -> 1
            "Sobrepeso" -> 2
            "Obesidad I" -> 3
            "Obesidad II" -> 4
            "Obesidad III" -> 5
            else -> 0
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("altura", if (::altura.isInitialized) altura else "")
        outState.putString("peso", if (::peso.isInitialized) peso else "")
        outState.putString("genero", if (::genero.isInitialized) genero else "")
        outState.putString("imc", if (::imc.isInitialized) imc else "")
        outState.putString("estado", if (::estado.isInitialized) estado else "")
        outState.putInt("iconos", iconos)
    }
}

