package com.example.consumocombustivel2.controller

import com.example.consumocombustivel2.dtos.PostoDTO
import com.example.consumocombustivel2.dtos.PostoResponseDTO
import com.example.consumocombustivel2.dtos.TipoResponseDTO
import com.example.consumocombustivel2.service.PostoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/postos")

class PostoController (val service: PostoService){

    @GetMapping
    fun listar() : List<PostoResponseDTO>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): PostoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: PostoDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PostoResponseDTO> {
        val postoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/postos/${postoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(postoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: PostoDTO
    ): PostoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }
}