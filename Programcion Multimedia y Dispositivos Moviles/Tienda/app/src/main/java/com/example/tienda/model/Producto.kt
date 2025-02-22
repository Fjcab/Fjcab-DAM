package com.example.tienda.model

import java.io.Serializable

data class Producto (
    val id: Long,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val images: List<String>,
    val thumbnail: String
):Serializable{

}