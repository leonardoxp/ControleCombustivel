package com.example.consumocombustivel2.dtos

data class PostoDTO(
    val id_posto: Int,
    val desc_posto: String,
    val preco: Double,
    val tipo_combustivel: String
)
