package com.example.consumocombustivel2.controller

import com.example.consumocombustivel2.dtos.AbastecimentoDTO
import com.example.consumocombustivel2.dtos.AbastecimentoResponseDTO
import com.example.consumocombustivel2.service.AbastecimentoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/abastecimentos")
class AbastecimentoController ( val service: AbastecimentoService){

    @GetMapping
    fun listar() : List<AbastecimentoResponseDTO>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AbastecimentoResponseDTO{
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: AbastecimentoDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AbastecimentoResponseDTO> {
        val abastecimentoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/abastecimentos/${abastecimentoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(abastecimentoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: AbastecimentoDTO
    ): AbastecimentoResponseDTO{
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }
}