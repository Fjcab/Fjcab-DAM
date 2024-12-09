package com.example.imc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var altura: String
    private lateinit var peso: String
    private lateinit var genero: String
    private lateinit var imc: String
    private lateinit var estado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            altura = savedInstanceState.getString("altura", "")
            peso = savedInstanceState.getString("peso", "")
            genero = savedInstanceState.getString("genero", "")
        }

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
            val intent = Intent(applicationContext,SecondActivity::class.java)
            val bundle: Bundle = Bundle()
            bundle.putString("altura", altura)
            bundle.putString("peso", peso)
            bundle.putString("genero", genero)
            bundle.putString("imc", imc)
            bundle.putString("estado", estado)
            bundle.putInt("iconos", iconos)
            intent.putExtra("datos",bundle)
            startActivity(intent)
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
    }
}
