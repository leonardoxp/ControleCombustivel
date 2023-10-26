package com.example.consumocombustivel2.dtos

import java.util.Date

data class VeiculoDTO(

    val id_veiculo: Int,
    val categoria: String,
    val ano: Date?,
    val cor: String,
    val desc_marca: String,
    val descricao: String,
    val potencia: Float?,
    val cons_cid: Float?,
    val cons_estrada: Float?,
    val combustivel: String,
    val tipo_id: Long
)
