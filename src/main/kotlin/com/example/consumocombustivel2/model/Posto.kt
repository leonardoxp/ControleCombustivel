package com.example.consumocombustivel2.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Posto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val id_posto: Int,
    val desc_posto: String,
    val preco: Double,
    val tipo_combustivel: String,
    @OneToMany(mappedBy = "posto")
    @JsonIgnore
    val abastecimentos: List<Abastecimento> = listOf()
)
