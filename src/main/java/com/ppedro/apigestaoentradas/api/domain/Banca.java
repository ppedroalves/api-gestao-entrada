package com.ppedro.apigestaoentradas.api.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "banca")
public class Banca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToOne
    private Pessoa pessoa;
    private Double valorInicial;
    private Double valorAtual;
    @OneToMany
    @JoinColumn(name = "banca_id")
    private List<Entrada> entradas;

}
