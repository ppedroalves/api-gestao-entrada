package com.ppedro.apigestaoentradas.api.domain.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    @NotEmpty(message = "O campo nome é obrigatorio")
    private String nome;
    @NotEmpty(message = "O campo cpf é obrigatorio")
    @CPF
    private String cpf;
    @NotEmpty(message = "O campo email é obrigatorio")
    @Email
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataNascimento;
}
