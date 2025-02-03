package com.example.presencial
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.presencial.databinding.ActivityPreguntasBinding
import com.example.presencial.model.Question
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import android.widget.RadioButton

class PreguntasActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityPreguntasBinding
    private lateinit var question: Question
    private lateinit var botonesRespuesta: List<RadioButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreguntasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnResponder.setOnClickListener(this)
        question = intent.getBundleExtra("datos")!!.getSerializable("pregunta") as Question
        binding.pregunta.text = question.question
        val conjuntoRespuestas = question.conjuntoRespuestas()
        botonesRespuesta = listOf(
            binding.respuesta1,
            binding.respuesta2,
            binding.respuesta3,
            binding.respuesta4
        )
        botonesRespuesta.forEachIndexed { index, boton ->
            if (index < conjuntoRespuestas.size && conjuntoRespuestas[index].isNotEmpty()) {
                boton.text = conjuntoRespuestas[index]
                boton.visibility = View.VISIBLE
            } else {
                boton.visibility = View.GONE
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnResponder.id->{
                val respuestaSeleccionada = botonesRespuesta.find {it.isChecked}
                if  (respuestaSeleccionada !=null){
                    val correcta = respuestaSeleccionada.text == question.correctAnswer
                    val mensaje = if(correcta){
                        "Correcto"
                    }else{
                        "Incorrecto. La respuesta correcta es: ${question.correctAnswer}"
                    }
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
                    val resultIntent = Intent().apply {
                        putExtra("position", intent.getIntExtra("position", -1))
                        putExtra("isCorrect", correcta)
                    }
                    setResult(RESULT_OK, resultIntent)
                    binding.root.postDelayed({
                        finish()
                    }, 1500) // Espera 1.5 segundos
                }else{
                    Toast.makeText(this, "Por favor, selecciona una respuesta", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}