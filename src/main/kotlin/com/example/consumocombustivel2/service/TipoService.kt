package com.example.consumocombustivel2.service

import com.example.consumocombustivel2.converters.TipoConverter
import com.example.consumocombustivel2.dtos.TipoDTO
import com.example.consumocombustivel2.dtos.TipoResponseDTO
import com.example.consumocombustivel2.exceptions.NotFoundException
import com.example.consumocombustivel2.model.Tipo

import com.example.consumocombustivel2.repository.TipoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Evento não encontrado!"

@Service
class TipoService(
    private val repository: TipoRepository,
    private val converter: TipoConverter
){

 //   fun listar(
 //       id: Long,
 //       paginacao: Pageable): Page<TipoResponseDTO> {
 //       val tipos = if (id == null) {
 //           repository.findAll(paginacao)
 //        } else {
 //           repository.findByid(id, paginacao)
 //       }
 //       return tipos
 //           .map(converter::toTipoResponseDTO)
 //   }




    fun listar(): List<TipoResponseDTO> {
        return repository.findAll()
            .map(converter::toTipoResponseDTO)
    }



    fun buscarPorId(id:Long): TipoResponseDTO{
        val tipo = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        return converter.toTipoResponseDTO(tipo)
    }

    fun cadastrar(dto: TipoDTO): TipoResponseDTO{
        return converter.toTipoResponseDTO(
            repository.save(converter.toTipo(dto))
        )
    }

    fun deletar (id: Long){
        repository.deleteById(id)
    }

    fun atualizar(id: Long, dto: TipoDTO): TipoResponseDTO{
        val tipo = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                id_tipo = dto.id_tipo,
                desc_tipo = dto.desc_tipo
            )
        return converter.toTipoResponseDTO(repository.save(tipo))
    }


}