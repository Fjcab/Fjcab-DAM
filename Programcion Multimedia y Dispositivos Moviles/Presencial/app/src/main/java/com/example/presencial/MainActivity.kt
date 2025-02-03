package com.example.presencial

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.presencial.adapter.TrivialAdapter
import com.example.presencial.databinding.ActivityMainBinding
import com.example.presencial.model.Question
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TrivialAdapter
    private lateinit var lista: ArrayList<Question>
    private var aciertos = 0
    private var fallos = 0
    private val respuestas = mutableMapOf<Int, Boolean>()
    private val isLandscape get() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()

        if (savedInstanceState != null) {
            val preguntasRecuperadas = savedInstanceState.getSerializable("preguntas") as? ArrayList<Question>
            if (preguntasRecuperadas != null) {
                lista.clear()
                lista.addAll(preguntasRecuperadas)
            }
            val respuestasMap = savedInstanceState.getSerializable("respuestasMap") as? HashMap<Int, Boolean>
            if (respuestasMap != null) {
                respuestas.clear()
                respuestas.putAll(respuestasMap)
                adapter.setRespuestasMap(respuestas)
            }
            aciertos = savedInstanceState.getInt("aciertos", 0)
            fallos = savedInstanceState.getInt("fallos", 0)
            actualizarContadores()
        } else {
            cargarPreguntasDesdeAPI()
        }
        lista.forEachIndexed { index, _ -> adapter.notifyItemChanged(index) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("preguntas", ArrayList(lista))
        outState.putSerializable("respuestasMap", HashMap(adapter.getRespuestasMap()))
        outState.putInt("aciertos", aciertos)
        outState.putInt("fallos", fallos)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            val position: Int? = data?.getIntExtra("position", -1)
            val isCorrect = data?.getBooleanExtra("isCorrect", false) ?: false

            if (position != null && position >= 0) {
                respuestas[position] = isCorrect
                adapter.actualizarRespuesta(position, isCorrect)
                actualizarContadores()
            }
        }
    }

    private fun instancias() {
        lista = ArrayList()
        adapter = TrivialAdapter(lista, this)
        binding.tarjetas.adapter = adapter
        binding.tarjetas.layoutManager = if (!isLandscape) {
            LinearLayoutManager(this)
        } else {
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun cargarPreguntasDesdeAPI() {
        val url = "https://opentdb.com/api.php?amount=25&category=9&difficulty=medium"
        val peticion = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                val results = response.getJSONArray("results")
                val gson = Gson()
                lista.clear()
                for (i in 0 until results.length()) {
                    val questionJson = results.getJSONObject(i)
                    val question = gson.fromJson(questionJson.toString(), Question::class.java)
                    lista.add(question)
                    adapter.notifyItemInserted(i)
                }
            },
            { error ->
                Toast.makeText(this, "Error al cargar las preguntas: ${error.message}",
                    Toast.LENGTH_SHORT).show()
            })
        Volley.newRequestQueue(this).add(peticion)
    }

    fun actualizarContadores() {
        if (!isLandscape) {
            aciertos = respuestas.count { it.value }
            fallos = respuestas.count { !it.value }
            
            binding.aciertos!!.text = "Aciertos: $aciertos"
            binding.fallos!!.text = "Fallos: $fallos"
            
            Log.d("MainActivity", "Actualizando contadores - Aciertos: $aciertos, Fallos: $fallos")
        }
    }
}
