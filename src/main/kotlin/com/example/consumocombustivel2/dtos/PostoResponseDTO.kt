package com.example.consumocombustivel2.dtos

data class PostoResponseDTO(
    val id: Long? = null,
    val id_posto: Int,
    val desc_posto: String,
    val preco: Double,
    val tipo_combustivel: String
)
