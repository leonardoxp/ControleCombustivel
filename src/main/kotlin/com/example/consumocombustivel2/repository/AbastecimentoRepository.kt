package com.example.consumocombustivel2.repository

import com.example.consumocombustivel2.model.Abastecimento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AbastecimentoRepository: JpaRepository<Abastecimento, Long> {
}