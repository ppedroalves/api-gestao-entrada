package com.ppedro.apigestaoentradas.api;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/api/v1/gestao-entradas")
public class EntradaController {

    @GetMapping("/teste")
    public String teste(){
        return "OK";
    }
}
