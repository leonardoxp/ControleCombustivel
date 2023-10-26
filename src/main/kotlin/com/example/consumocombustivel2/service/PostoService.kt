package com.example.consumocombustivel2.service

import com.example.consumocombustivel2.converters.PostoConverter
import com.example.consumocombustivel2.dtos.PostoDTO
import com.example.consumocombustivel2.dtos.PostoResponseDTO
import com.example.consumocombustivel2.dtos.TipoResponseDTO
import com.example.consumocombustivel2.exceptions.NotFoundException
import com.example.consumocombustivel2.model.Posto
import com.example.consumocombustivel2.repository.PostoRepository
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Posto não encontrado!"

@Service
class PostoService (
    private val repository: PostoRepository,
    private val converter: PostoConverter
){

    fun listar(): List<PostoResponseDTO> {
        return repository.findAll()
            .map(converter::toPostoResponseDTO)
    }

    fun buscarPorId(id:Long): PostoResponseDTO{
        val posto = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        return converter.toPostoResponseDTO(posto)
    }

    fun cadastrar(dto: PostoDTO): PostoResponseDTO{
        return converter.toPostoResponseDTO(
            repository.save(converter.toPosto(dto))
        )
    }

    fun atualizar(id:Long, dto: PostoDTO): PostoResponseDTO{
        val posto = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                id_posto = dto.id_posto,
                desc_posto = dto.desc_posto,
                preco = dto.preco,
                tipo_combustivel = dto.tipo_combustivel
            )
        return converter.toPostoResponseDTO(repository.save(posto))
    }

    fun deletar (id: Long){
        repository.deleteById(id)
    }

}