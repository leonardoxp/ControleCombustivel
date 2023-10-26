package com.example.consumocombustivel2.dtos

import com.example.consumocombustivel2.model.Tipo
import com.example.consumocombustivel2.model.Veiculo
import java.util.*

data class VeiculoResponseDTO(
    val id: Long? = null,
    val id_veiculo: Int,
    val categoria: String,
    val ano: Date?,
    val cor: String,
    val desc_marca: String,
    val descricao: String,
    val potencia: Float?,
    val cons_cid: Float?,
    val cons_estrada: Float?,
    val combustivel: String
    //val tipos: List<Tipo>

)
