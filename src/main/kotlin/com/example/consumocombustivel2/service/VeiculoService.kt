package com.example.consumocombustivel2.service

import com.example.consumocombustivel2.converters.VeiculoConverter
import com.example.consumocombustivel2.dtos.TipoResponseDTO
import com.example.consumocombustivel2.dtos.VeiculoDTO
import com.example.consumocombustivel2.dtos.VeiculoResponseDTO
import com.example.consumocombustivel2.exceptions.NotFoundException
import com.example.consumocombustivel2.repository.VeiculoRepository
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Evento não encontrado!"
@Service
class VeiculoService (
    private val repository: VeiculoRepository,
    private val converter: VeiculoConverter
){

    fun listar(): List<VeiculoResponseDTO> {
        return repository.findAll()
            .map(converter::toVeiculoResponseDTO)
    }

    fun buscarPorId(id:Long): VeiculoResponseDTO{
        val veiculo = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        return converter.toVeiculoResponseDTO(veiculo)
    }

    fun atualizar(id: Long, dto: VeiculoDTO): VeiculoResponseDTO{
        val veiculo = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                id_veiculo = dto.id_veiculo,
                categoria = dto.categoria,
                ano = dto.ano,
                cor = dto.cor,
                desc_marca = dto.desc_marca,
                descricao = dto.descricao,
                potencia = dto.potencia,
                cons_cid = dto.cons_cid,
                cons_estrada = dto.cons_estrada,
                combustivel = dto.combustivel
            )
        return converter.toVeiculoResponseDTO(repository.save(veiculo))
    }

    fun cadastrar (dto: VeiculoDTO): VeiculoResponseDTO{
        return converter.toVeiculoResponseDTO(
            repository.save(converter.toVeiculo(dto)))
    }

    fun deletar (id: Long) {
        repository.deleteById(id)
    }
}