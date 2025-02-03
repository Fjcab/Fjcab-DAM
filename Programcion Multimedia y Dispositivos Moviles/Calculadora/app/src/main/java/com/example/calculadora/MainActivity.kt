package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.calculadora.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.tan

class MainActivity : AppCompatActivity(), OnClickListener, OnCheckedChangeListener{

    private lateinit var binding: ActivityMainBinding


    private var operacion = ""
    private var total = ""
    private var operador: String? = null
    private var num1 = 0.0
    private var num2 = 0.0
    private var tema = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        num1 = savedInstanceState?.getDouble("num1") ?: 0.0
        num2 = savedInstanceState?.getDouble("num2") ?: 0.0
        operacion = savedInstanceState?.getString("operacion") ?: ""
        total = savedInstanceState?.getString("total") ?: ""
        operador = savedInstanceState?.getString("operador") ?: null
        tema = savedInstanceState?.getBoolean("tema", false) ?: false
        binding.txtOperacion.text = operacion
        binding.txtResultado.text = total
        binding.SwitchTema?.setOnCheckedChangeListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.btn0.setOnClickListener(this)
        binding.btn00.setOnClickListener(this)
        binding.btnSuma.setOnClickListener(this)
        binding.btnResta.setOnClickListener(this)
        binding.btnMultiplicar.setOnClickListener(this)
        binding.btnDividir.setOnClickListener(this)
        binding.btnPorcentaje.setOnClickListener(this)
        binding.btnIgual.setOnClickListener(this)
        binding.btnBorrar.setOnClickListener(this)
        binding.btnReinicio.setOnClickListener(this)
        binding.btnCuadrado?.setOnClickListener(this)
        binding.btnPotencia?.setOnClickListener(this)
        binding.btnRaiz?.setOnClickListener(this)
        binding.btnSen?.setOnClickListener(this)
        binding.btnCos?.setOnClickListener(this)
        binding.btnTang?.setOnClickListener(this)
        binding.btnFactorial?.setOnClickListener(this)
        binding.btnPi?.setOnClickListener(this)
        binding.btnE?.setOnClickListener(this)
        binding.btnPunto?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
       when(v?.id){
           binding.btn1.id->{
               if (operacion == "0"){
                   operacion = "1"
               }else{
               operacion += "1"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn2.id->{
               if (operacion == "0"){
                   operacion = "2"
               }else{
                   operacion += "2"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn3.id->{
               if (operacion == "0"){
                   operacion = "3"
               }else{
                   operacion += "3"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn4.id->{
               if (operacion == "0"){
                   operacion = "4"
               }else{
                   operacion += "4"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn5.id->{
               if (operacion == "0"){
                   operacion = "5"
               }else{
                   operacion += "5"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn6.id->{
               if (operacion == "0"){
                   operacion = "6"
               }else{
                   operacion += "6"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn7.id->{
               if (operacion == "0"){
                   operacion = "7"
               }else{
                   operacion += "7"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn8.id->{
               if (operacion == "0"){
                   operacion = "8"
               }else{
                   operacion += "8"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn9.id->{
               if (operacion == "0"){
                   operacion = "9"
               }else{
                   operacion += "9"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btnPi?.id->{
               if (operacion.isEmpty() || esUltimoOperador(operacion)){
               operacion += "3.1416"
               binding.txtOperacion.text = operacion
               }else{
                   Snackbar.make(binding.root, "Elimina el numero actual.", Snackbar.LENGTH_SHORT).show()
               }
           }
           binding.btnE?.id->{
               if (operacion.isEmpty() || esUltimoOperador(operacion)){
                   operacion += "2.7183"
                   binding.txtOperacion.text = operacion
               }else{
                   Snackbar.make(binding.root, "Elimina el numero actual.", Snackbar.LENGTH_SHORT).show()
               }
             }
           binding.btn0.id->{
               if (operacion == "0"){
                   operacion = "0"
               }else{
                   operacion += "0"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btn00.id->{
               if(operacion.isEmpty() || operacion=="0"){
                   operacion = "0"
               }else{
                   operacion += "00"
               }
               binding.txtOperacion.text = operacion
           }
           binding.btnPunto?.id->{
               if(operacion.isEmpty() || esUltimoOperador(operacion)){
               operacion += "0."
               }else{
                   if(operador!=null){
                       var operadorIndex = operacion.indexOf(operador!!)
                       var subOperacion = operacion.substring(operadorIndex+1)
                       if (subOperacion.contains('.')){
                           Snackbar.make(binding.root, "No puedes incluir otro decimal", Snackbar.LENGTH_SHORT).show()
                       }else{
                           operacion += "."
                       }
                   }else{
                       if(operacion.contains('.')){
                           Snackbar.make(binding.root, "No puedes incluir otro decimal", Snackbar.LENGTH_SHORT).show()
                       }else{
                   operacion += "."
                       }
                   }
               }
                   binding.txtOperacion.text = operacion
           }
           binding.btnSuma.id->{
               if (operador!=null){
                   Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
               }else{
                   if(operacion.isEmpty()){
                       operacion+="0+"
                   }else{
                       operacion+="+"
                   }
               operador="+"
               binding.txtOperacion.text = operacion
               }
           }
           binding.btnResta.id->{
               if (operador!=null){
                   Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
               }else{
                   if(operacion.isEmpty()){
                       operacion+="0-"
                   }else{
                       operacion+="-"
                   }
               operador="-"
               binding.txtOperacion.text = operacion
               }
           }
           binding.btnMultiplicar.id->{
               if (operador!=null){
                   Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
               }else{
                   if(operacion.isEmpty()){
                       operacion+="0*"
                   }else{
                       operacion+="*"
                   }
               operador="*"
               binding.txtOperacion.text = operacion
               }
           }
           binding.btnDividir.id->{
               if (operador!=null){
                   Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
               }else{
                   if(operacion.isEmpty()){
                       operacion+="0/"
                   }else{
                       operacion+="/"
                   }
               operador="/"
               binding.txtOperacion.text = operacion
               }
           }
           binding.btnPorcentaje.id->{
               if(operacion.isNotEmpty()){
                   if (operador == null) {
                       num1 = operacion.toDoubleOrNull() ?:0.0
                       var resultado = num1 / 100
                       operacion =  if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
                       total = operacion
                       binding.txtOperacion.text = operacion
                       binding.txtResultado.text = total
                   }else{
                       Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
                   }
               }else{
                   operacion = "0"
                   total = operacion
                   binding.txtOperacion.text = operacion
                   binding.txtResultado.text = total
               }
           }
           binding.btnCuadrado?.id->{
               if(operacion.isNotEmpty()){
                   if (operador == null) {
                       num1 = operacion.toDoubleOrNull() ?:0.0
                       var resultado = num1 * num1
                       operacion =  if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
                       total = operacion
                       binding.txtOperacion.text = operacion
                       binding.txtResultado.text = total
                   }else{
                       Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
                   }
               }else{
                   operacion = "0"
                   total = operacion
                   binding.txtOperacion.text = operacion
                   binding.txtResultado.text = total
               }
           }
           binding.btnPotencia?.id->{
               if (operador!=null){
                   Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
               }else{
                   if(operacion.isEmpty()){
                       operacion+="0^"
                   }else{
                       operacion+="^"
                   }
                   operador="^"
                   binding.txtOperacion.text = operacion
               }
           }
           binding.btnRaiz?.id->{
               if (operador!=null){
                   Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
               }else{
                   if(operacion.isEmpty()){
                       operacion+="0√"
                   }else{
                       operacion+="√"
                   }
                   operador="√"
                   binding.txtOperacion.text = operacion
               }
           }
           binding.btnFactorial?.id->{
               if(operacion.isNotEmpty()){
                   if (operador == null) {
                       if (operacion.contains('.')){
                           Snackbar.make(binding.root, "Debes usar un numero entero", Snackbar.LENGTH_SHORT).show()
                       }else{
                       var resultado: Int = 1
                       num1 = operacion.toDoubleOrNull() ?:0.0
                           for (i in 1..num1.toInt()){
                               resultado *= i
                           }
                       operacion = resultado.toString()
                       total = operacion
                       binding.txtOperacion.text = operacion
                       binding.txtResultado.text = total
                       }
                   }else{
                       Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
                   }
               }else{
                   operacion = "0"
                   total = operacion
                   binding.txtOperacion.text = operacion
                   binding.txtResultado.text = total
               }
           }
           binding.btnSen?.id->{
               if(operacion.isNotEmpty()){
                   if (operador == null) {
                       if(binding.toggleGrad?.isChecked == true){
                           num1 = operacion.toDoubleOrNull() ?:0.0
                           var resultado = sin(Math.toRadians(num1))
                           operacion =  if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
                           total = operacion
                           binding.txtOperacion.text = operacion
                           binding.txtResultado.text = total
                       }else{
                       num1 = operacion.toDoubleOrNull() ?:0.0
                       var resultado = sin(num1)
                       operacion =  if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
                       total = operacion
                       binding.txtOperacion.text = operacion
                       binding.txtResultado.text = total
                       }
                   }else{
                       Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
                   }
               }else{
                   operacion = "0"
                   total = operacion
                   binding.txtOperacion.text = operacion
                   binding.txtResultado.text = total
               }
           }
           binding.btnCos?.id->{
               if(operacion.isNotEmpty()){
                   if (operador == null) {
                       if(binding.toggleGrad?.isChecked == true){
                           num1 = operacion.toDoubleOrNull() ?:0.0
                           var resultado = cos(Math.toRadians(num1))
                           operacion =  if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
                           total = operacion
                           binding.txtOperacion.text = operacion
                           binding.txtResultado.text = total
                       }else{
                       num1 = operacion.toDoubleOrNull() ?:0.0
                       var resultado = cos(num1)
                       operacion =  if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
                       total = operacion
                       binding.txtOperacion.text = operacion
                       binding.txtResultado.text = total
                       }
                   }else{
                       Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
                   }
               }else{
                   operacion = "1"
                   total = operacion
                   binding.txtOperacion.text = operacion
                   binding.txtResultado.text = total
               }
           }           binding.btnTang?.id->{
               if(operacion.isNotEmpty()){
                   if (operador == null) {
                       if(binding.toggleGrad?.isChecked == true){
                           num1 = operacion.toDoubleOrNull() ?:0.0
                           var resultado = tan(Math.toRadians(num1))
                           operacion =  if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
                           total = operacion
                           binding.txtOperacion.text = operacion
                           binding.txtResultado.text = total
                       }else{
                       num1 = operacion.toDoubleOrNull() ?:0.0
                       var resultado = tan(num1)
                       operacion =  if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
                       total = operacion
                       binding.txtOperacion.text = operacion
                       binding.txtResultado.text = total
                       }
                   }else{
                       Snackbar.make(binding.root, "Completa la Operación", Snackbar.LENGTH_SHORT).show()
                   }
               }else{
                   operacion = "0"
                   total = operacion
                   binding.txtOperacion.text = operacion
                   binding.txtResultado.text = total
               }
           }

           binding.btnIgual.id->{
               realizarOperacion()
           }
           binding.btnBorrar.id->{
               borrarUltimo()
           }
           binding.btnReinicio.id->{
               reinicio()
           }
       }
    }

    private fun realizarOperacion() {
        if (operador != null && operacion.isNotEmpty()) {
            var operadorIndex = operacion.indexOf(operador!!)
            num1 = operacion.substring(0, operadorIndex).toDoubleOrNull() ?:0.0
            num2 = operacion.substring(operadorIndex+1).toDoubleOrNull() ?:0.0

            var resultado = when (operador) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                "^" -> num1.pow(num2)
                "√" -> num1.pow(1.0 / num2)
                else -> 0.0
            }
            operacion = if (resultado % 1.0 == 0.0) resultado.toInt().toString() else resultado.toString()
            total = operacion
            binding.txtOperacion.text = operacion
            binding.txtResultado.text = total
            operador = null
        } else {
            Snackbar.make(binding.root, "Operación incompleta", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun esUltimoOperador(cadena: String): Boolean {
        val ultimoChar = cadena.last()
        return ultimoChar == '+' || ultimoChar == '-' || ultimoChar == '*' || ultimoChar == '/'|| ultimoChar == '^'|| ultimoChar == '√'
    }

    private fun borrarUltimo() {
        if (operacion.isNotEmpty()) {
            if (esUltimoOperador(operacion)) {
                operador = null
            }
            operacion = operacion.dropLast(1)
            binding.txtOperacion.text = operacion
        }
    }

    private fun reinicio() {
        num1 = 0.0
        num2 = 0.0
        operacion = ""
        operador = null
        total = ""
        binding.txtOperacion.text = operador
        binding.txtResultado.text = total
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        tema = binding.SwitchTema?.isChecked ?: false
        outState.putBoolean("tema", tema)
        outState.putString("operador", operador)
        outState.putString("operacion", operacion)
        outState.putString("total", total)
        outState.putDouble("num1", num1)
        outState.putDouble("num1", num2)
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when(p0?.id){
            binding.SwitchTema?.id -> {
                if(p1){
                    darkMode()
                }else{
                    dayMode()
                }

            }
        }
    }
    private fun darkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
    }
    private fun dayMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        delegate.applyDayNight()
    }

}