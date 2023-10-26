package com.example.consumocombustivel2.converters

import com.example.consumocombustivel2.dtos.PostoDTO
import com.example.consumocombustivel2.dtos.PostoResponseDTO
import com.example.consumocombustivel2.model.Posto
import org.springframework.stereotype.Component


@Component
class PostoConverter {

    fun toPosto(dto: PostoDTO): Posto {
        return Posto(
            id_posto = dto.id_posto,
            desc_posto = dto.desc_posto,
            preco = dto.preco,
            tipo_combustivel = dto.tipo_combustivel
        )
    }

    fun toPostoResponseDTO(posto: Posto): PostoResponseDTO {
        return PostoResponseDTO(
            id = posto.id,
            id_posto = posto.id_posto,
            desc_posto = posto.desc_posto,
            preco = posto.preco,
            tipo_combustivel = posto.tipo_combustivel
        )
        }
}