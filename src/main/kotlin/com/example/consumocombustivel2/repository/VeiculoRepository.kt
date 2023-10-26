package com.example.consumocombustivel2.repository

import com.example.consumocombustivel2.model.Veiculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface VeiculoRepository: JpaRepository<Veiculo, Long> {
}