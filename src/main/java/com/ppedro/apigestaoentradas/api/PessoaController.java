package com.ppedro.apigestaoentradas.api;


import com.ppedro.apigestaoentradas.api.domain.Pessoa;
import com.ppedro.apigestaoentradas.api.domain.dtos.PessoaDTO;
import com.ppedro.apigestaoentradas.api.service.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/gestao-entradas/pessoa")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;


    @PostMapping()
    public ResponseEntity create(@RequestBody @Valid PessoaDTO pessoa) {
        return ResponseEntity.ok().body(pessoaService.create(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }
}
