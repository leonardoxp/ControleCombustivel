package com.example.consumocombustivel2.controller

import com.example.consumocombustivel2.dtos.TipoResponseDTO
import com.example.consumocombustivel2.dtos.VeiculoDTO
import com.example.consumocombustivel2.dtos.VeiculoResponseDTO
import com.example.consumocombustivel2.model.Veiculo
import com.example.consumocombustivel2.service.VeiculoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/veiculos")
class VeiculoController ( val service: VeiculoService) {


    @GetMapping
    fun listar() : List<VeiculoResponseDTO>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): VeiculoResponseDTO {
        return service.buscarPorId(id)
    }
    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: VeiculoDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<VeiculoResponseDTO> {
        val userResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/veiculos/${userResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(userResponse)
    }
    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: VeiculoDTO
    ): VeiculoResponseDTO {
        return service.atualizar(id,dto)
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar (@PathVariable id: Long){
        service.deletar(id)
    }
}