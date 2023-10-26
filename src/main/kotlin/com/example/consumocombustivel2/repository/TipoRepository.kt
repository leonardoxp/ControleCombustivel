package com.example.consumocombustivel2.repository

import com.example.consumocombustivel2.model.Tipo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TipoRepository: JpaRepository<Tipo, Long> {

 //   fun findByid(id: Long, paginacao: Pageable): Page<Tipo>

}