package com.example.consumocombustivel2.controller

import com.example.consumocombustivel2.dtos.TipoDTO
import com.example.consumocombustivel2.dtos.TipoResponseDTO
import com.example.consumocombustivel2.model.Tipo
import com.example.consumocombustivel2.service.TipoService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/tipos")
class TipoController (val service: TipoService) {

 //   @GetMapping
 //   fun listar(
 //       @RequestParam(required = false) id: Long,
 //       @PageableDefault(size = 10) paginacao: Pageable)
 //           : Page<TipoResponseDTO> {
 //       return service.listar(id, paginacao)
 //   }



    @GetMapping
    fun listar() : List<TipoResponseDTO>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): TipoResponseDTO{
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: TipoDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TipoResponseDTO> {
        val tipoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/tipos/${tipoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(tipoResponse)

    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: TipoDTO
    ): TipoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar (@PathVariable id: Long){
        service.deletar(id)
    }
}