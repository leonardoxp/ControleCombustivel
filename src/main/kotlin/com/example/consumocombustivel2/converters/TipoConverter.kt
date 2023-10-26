package com.example.consumocombustivel2.converters

import com.example.consumocombustivel2.dtos.TipoDTO
import com.example.consumocombustivel2.dtos.TipoResponseDTO
import com.example.consumocombustivel2.model.Tipo
import org.springframework.stereotype.Component


@Component
class TipoConverter {

    fun toTipoResponseDTO(tipo: Tipo): TipoResponseDTO{
        return TipoResponseDTO(
            id = tipo.id,
            id_tipo = tipo.id_tipo,
            desc_tipo = tipo.desc_tipo,
            veiculos = tipo.veiculos
        )
    }

    fun toTipo(dto: TipoDTO): Tipo{
        return Tipo(
            id_tipo = dto.id_tipo,
            desc_tipo = dto.desc_tipo,
            veiculos = listOf()
        )
    }

}