package com.example.consumocombustivel2.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.util.*

@Entity
data class Veiculo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    val combustivel: String,
    @ManyToOne
    @JsonIgnore
    val tipo: Tipo,
    @OneToMany(mappedBy = "veiculo")
    @JsonIgnoreProperties("veiculo")
    val abastecimentos: List<Abastecimento> = listOf()
)
