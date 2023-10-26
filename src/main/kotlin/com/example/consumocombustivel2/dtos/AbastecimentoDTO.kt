package com.example.consumocombustivel2.dtos

import java.util.*

data class AbastecimentoDTO(
    val id_abast: Int,
    val data_abast: Date?,
    val combustivel: String,
    val qtd_litros: Float?,
    val valor_abast: Double,
    val km_atual: Float?,
    val posto_id: Long,
    val veiculo_id: Long
)
