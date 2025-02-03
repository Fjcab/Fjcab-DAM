package com.example.presencial.adapter

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.presencial.MainActivity
import com.example.presencial.PreguntasActivity
import com.example.presencial.R
import com.example.presencial.model.Question

class TrivialAdapter(var lista: ArrayList<Question>, var context: Context) : RecyclerView.Adapter<TrivialAdapter.MyHolder>() {

    private val respuestasMap = mutableMapOf<Int, Boolean>()
    private val isLandscape = context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pregunta: TextView = itemView.findViewById(R.id.pregunta)
        val cardView: CardView = itemView.findViewById(R.id.tarjeta)
        val respuestasGroup: RadioGroup? = if (isLandscape) itemView.findViewById(R.id.respuestas) else null
        val btnResponder: Button? = if (isLandscape) itemView.findViewById(R.id.btnResponder) else null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(context).inflate(R.layout.trivial, parent, false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val question = lista[position]
        holder.pregunta.text = Html.fromHtml(question.question, Html.FROM_HTML_MODE_LEGACY)

        if (!isLandscape) {
            holder.itemView.setOnClickListener {
                val intent = Intent(context, PreguntasActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("pregunta", question)
                intent.putExtra("datos", bundle)
                intent.putExtra("position", position)
                (context as MainActivity).startActivityForResult(intent, 1)
            }
        } else {
            holder.respuestasGroup?.let { group ->
                group.removeAllViews()
                question.conjuntoRespuestas().forEach { respuesta ->
                    val radioButton = RadioButton(context).apply {
                        text = Html.fromHtml(respuesta, Html.FROM_HTML_MODE_LEGACY)
                        layoutParams = RadioGroup.LayoutParams(
                            RadioGroup.LayoutParams.MATCH_PARENT,
                            RadioGroup.LayoutParams.WRAP_CONTENT
                        )
                        setPadding(16, 16, 16, 16)
                    }
                    group.addView(radioButton)
                }
            }

            holder.btnResponder?.setOnClickListener {
                val selectedId = holder.respuestasGroup?.checkedRadioButtonId
                if (selectedId != -1) {
                    val selectedButton = holder.respuestasGroup?.findViewById<RadioButton>(selectedId ?: -1)
                    val isCorrect = selectedButton?.text.toString() == question.correctAnswer

                    cambiarFondo(position, isCorrect)

                    val mensaje = if (isCorrect) {
                        "¡Correcto!"
                    } else {
                        "Incorrecto. La respuesta correcta era: ${question.correctAnswer}"
                    }
                    Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()

                    holder.btnResponder?.isEnabled = false
                    holder.respuestasGroup?.isEnabled = false
                } else {
                    Toast.makeText(context, "Por favor, selecciona una respuesta",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        respuestasMap[position]?.let { isCorrect ->
            val color = if (isCorrect) {
                ContextCompat.getColor(context, R.color.green)
            } else {
                ContextCompat.getColor(context, R.color.red)
            }
            holder.cardView.setCardBackgroundColor(color)

            if (isLandscape) {
                holder.btnResponder?.isEnabled = false
                holder.respuestasGroup?.isEnabled = false
            }
        } ?: run {
            holder.cardView.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.white)
            )
        }
    }

    override fun getItemCount(): Int = lista.size

    fun getRespuestasMap(): Map<Int, Boolean> = respuestasMap.toMap()

    fun setRespuestasMap(map: Map<Int, Boolean>) {
        respuestasMap.clear()
        respuestasMap.putAll(map)
        notifyItemRangeChanged(0, lista.size)
    }

    fun actualizarRespuesta(position: Int, isCorrect: Boolean) {
        respuestasMap[position] = isCorrect
        notifyItemChanged(position)
    }

    fun cambiarFondo(position: Int?, isCorrect: Boolean) {
        if (position != null && position != -1) {
            respuestasMap[position] = isCorrect
            notifyItemChanged(position)
            (context as? MainActivity)?.actualizarContadores()
        }
    }
}
