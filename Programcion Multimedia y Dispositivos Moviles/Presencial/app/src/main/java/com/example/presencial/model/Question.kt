package com.example.presencial.model

import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("question") val question: String? = null,
    @SerializedName("correct_answer") val correctAnswer: String? = null,
    @SerializedName("incorrect_answers") val incorrectAnswers: List<String>? = null,
    @SerializedName("category") val category: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("difficulty") val difficulty: String? = null
) : Serializable {
    // codigo que se ejecute tras el constructor
    init{

    }

    fun conjuntoRespuestas(): ArrayList<String> {
        val conjuntoRespuestas = ArrayList<String>()
        correctAnswer?.let { conjuntoRespuestas.add(it) }
        incorrectAnswers?.let { conjuntoRespuestas.addAll(it) }
        conjuntoRespuestas.shuffle()
        return conjuntoRespuestas
    }
}
