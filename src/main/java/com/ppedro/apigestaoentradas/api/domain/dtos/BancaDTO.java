package com.ppedro.apigestaoentradas.api.domain.dtos;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BancaDTO {

    @NotNull(message = "O campo idPesoa é obrigatorio")
    private Long idPessoa;
    @NotEmpty(message = "O campo nome é obrigatorio")
    private String nome;
    @NotNull(message = "O campo valorInicial é obrigatorio")
    private Double valorInicial;
}
