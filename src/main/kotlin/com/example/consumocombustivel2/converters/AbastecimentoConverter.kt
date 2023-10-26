package com.example.consumocombustivel2.converters

import com.example.consumocombustivel2.dtos.AbastecimentoDTO
import com.example.consumocombustivel2.dtos.AbastecimentoResponseDTO
import com.example.consumocombustivel2.model.Abastecimento
import java.util.*
import com.example.consumocombustivel2.repository.PostoRepository
import com.example.consumocombustivel2.repository.VeiculoRepository
import org.springframework.stereotype.Component


@Component
class AbastecimentoConverter (val postoRepository: PostoRepository, val veiculoRepository: VeiculoRepository){

    fun toAbastecimentoResponseDTO(abastecimento: Abastecimento): AbastecimentoResponseDTO {
        return AbastecimentoResponseDTO(
            id = abastecimento.id,
            id_abast = abastecimento.id_abast,
            data_abast = abastecimento.data_abast,
            combustivel = abastecimento.combustivel,
            qtd_litros = abastecimento.qtd_litros,
            valor_abast = abastecimento.valor_abast,
            km_atual = abastecimento.km_atual,
        )
    }

    fun toAbastecimento(dto: AbastecimentoDTO): Abastecimento{
        return Abastecimento(
            id_abast = dto.id_abast,
            data_abast = dto.data_abast,
            combustivel = dto.combustivel,
            qtd_litros = dto.qtd_litros,
            valor_abast = dto.valor_abast,
            km_atual = dto.km_atual,
            posto = postoRepository.findById(dto.posto_id).get(),
            veiculo = veiculoRepository.getReferenceById(dto.veiculo_id)
        )
    }
}