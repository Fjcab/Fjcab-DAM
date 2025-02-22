package com.example.tienda.model

import java.io.Serializable

data class Categoria (
    val slug: String,
    val name: String = slug,
): Serializable{



}
