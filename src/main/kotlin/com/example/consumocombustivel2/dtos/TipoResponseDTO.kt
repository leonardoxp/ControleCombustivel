package com.example.consumocombustivel2.dtos

import com.example.consumocombustivel2.model.Veiculo

data class TipoResponseDTO(
    val id: Long? = null,
    val id_tipo: Int,
    val desc_tipo: String,
    val veiculos: List<Veiculo>
)
