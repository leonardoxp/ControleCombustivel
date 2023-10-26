package com.example.consumocombustivel2.service

import com.example.consumocombustivel2.converters.AbastecimentoConverter
import com.example.consumocombustivel2.dtos.AbastecimentoDTO
import com.example.consumocombustivel2.dtos.AbastecimentoResponseDTO
import com.example.consumocombustivel2.exceptions.NotFoundException
import com.example.consumocombustivel2.repository.AbastecimentoRepository
import org.springframework.stereotype.Service


private const val EVENTO_NOT_FOUND_MESSAGE = "Evento não encontrado!"
@Service
class AbastecimentoService (
    private val repository: AbastecimentoRepository,
    private val converter: AbastecimentoConverter
){

    fun listar(): List<AbastecimentoResponseDTO> {
        return repository.findAll()
            .map(converter::toAbastecimentoResponseDTO)
    }

    fun buscarPorId (id:Long): AbastecimentoResponseDTO{
        val abastecimento = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE)  }
        return converter.toAbastecimentoResponseDTO(abastecimento)
    }

    fun cadastrar (dto: AbastecimentoDTO) : AbastecimentoResponseDTO{
        return converter.toAbastecimentoResponseDTO(
            repository.save(converter.toAbastecimento(dto))
        )
    }

    fun atualizar(id: Long, dto: AbastecimentoDTO) : AbastecimentoResponseDTO{
        val abastecimento = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                id_abast = dto.id_abast,
                data_abast = dto.data_abast,
                combustivel = dto.combustivel,
                qtd_litros = dto.qtd_litros,
                valor_abast = dto.valor_abast,
                km_atual = dto.km_atual,

                )
        return converter.toAbastecimentoResponseDTO(repository.save(abastecimento))
    }

    fun deletar (id:Long){
        repository.deleteById(id)
    }

}