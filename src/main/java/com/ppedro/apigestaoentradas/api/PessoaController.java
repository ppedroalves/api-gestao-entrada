package com.ppedro.apigestaoentradas.api;


import com.ppedro.apigestaoentradas.api.domain.Pessoa;
import com.ppedro.apigestaoentradas.api.domain.dtos.PessoaDTO;
import com.ppedro.apigestaoentradas.api.service.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ppedro.utils.APPLICATION_PATH.BASE_PATH_V1;

@RestController
@RequestMapping(BASE_PATH_V1)
@AllArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;


    @PostMapping("/pessoa")
    public ResponseEntity create(@RequestBody @Valid PessoaDTO pessoa) {
        return ResponseEntity.ok().body(pessoaService.create(pessoa));
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }
}
