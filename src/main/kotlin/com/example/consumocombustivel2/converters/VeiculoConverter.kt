package com.example.consumocombustivel2.converters

import com.example.consumocombustivel2.dtos.TipoDTO
import com.example.consumocombustivel2.dtos.VeiculoDTO
import com.example.consumocombustivel2.dtos.VeiculoResponseDTO
import com.example.consumocombustivel2.model.Tipo
import com.example.consumocombustivel2.model.Veiculo
import com.example.consumocombustivel2.repository.TipoRepository
import org.springframework.stereotype.Component
import java.util.*


@Component
class VeiculoConverter(val tipoRepository: TipoRepository) {

    fun toVeiculoResponseDTO(veiculo: Veiculo): VeiculoResponseDTO{
        return VeiculoResponseDTO(
            id = veiculo.id,
            id_veiculo = veiculo.id_veiculo,
            categoria = veiculo.categoria,
            ano = veiculo.ano,
            cor = veiculo.cor,
            desc_marca = veiculo.desc_marca,
            descricao = veiculo.descricao,
            potencia = veiculo.potencia,
            cons_cid = veiculo.cons_cid,
            cons_estrada = veiculo.cons_estrada,
            combustivel = veiculo.combustivel)
    }

    fun toVeiculo(dto: VeiculoDTO): Veiculo{
        return Veiculo(
            id_veiculo = dto.id_veiculo,
            categoria = dto.categoria,
            ano = dto.ano,
            cor = dto.cor,
            desc_marca = dto.desc_marca,
            descricao = dto.descricao,
            potencia = dto.potencia,
            cons_cid = dto.cons_cid,
            cons_estrada = dto.cons_estrada,
            combustivel = dto.combustivel,
            tipo = tipoRepository.findById(dto.tipo_id).get()
        )

    }

}