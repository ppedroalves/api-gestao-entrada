package com.ppedro.apigestaoentradas.api;


import com.ppedro.apigestaoentradas.api.domain.dtos.BancaDTO;
import com.ppedro.apigestaoentradas.api.service.BancaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ppedro.utils.APPLICATION_PATH.BASE_PATH_V1;

@RestController
@RequestMapping(BASE_PATH_V1)
@AllArgsConstructor
public class BancaController {

    private BancaService bancaService;

    @PostMapping("/banca")
    public ResponseEntity create(@Valid @RequestBody BancaDTO banca){
        return ResponseEntity.ok().body(bancaService.create(banca));
    }

}
