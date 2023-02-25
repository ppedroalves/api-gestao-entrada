package com.ppedro.apigestaoentradas.api.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ppedro.apigestaoentradas.api.domain.dtos.PessoaDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "pessoa")
@Data
@NoArgsConstructor
public class Pessoa{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataNascimento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "banca_id")
    private Banca banca;


    public Pessoa(PessoaDTO pessoa){
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.email = pessoa.getEmail();
        this.dataNascimento = pessoa.getDataNascimento();
    }

}
