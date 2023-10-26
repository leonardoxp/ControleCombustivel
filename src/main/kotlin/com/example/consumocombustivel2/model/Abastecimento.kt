package com.example.consumocombustivel2.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*


@Entity
data class Abastecimento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val id_abast: Int,
    val data_abast: Date?,
    val combustivel: String,
    val qtd_litros: Float?,
    val valor_abast: Double,
    val km_atual: Float?,
    @ManyToOne
    @JsonIgnore
    val posto: Posto,
    @ManyToOne
    val veiculo: Veiculo

)

