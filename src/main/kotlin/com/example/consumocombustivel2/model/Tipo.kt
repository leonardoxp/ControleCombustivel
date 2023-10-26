package com.example.consumocombustivel2.model


import jakarta.persistence.*


@Entity
data class Tipo (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val id_tipo: Int,
    val desc_tipo: String,
    @OneToMany(mappedBy = "tipo")
    val veiculos: List<Veiculo> = listOf()

    )
