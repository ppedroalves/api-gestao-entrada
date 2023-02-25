package com.ppedro.apigestaoentradas.api.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ppedro.apigestaoentradas.api.domain.dtos.BancaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "banca")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Banca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToOne(mappedBy = "banca")
    @JsonIgnore
    private Pessoa pessoa;
    private Double valorInicial;
    private Double valorAtual;
    @OneToMany
    @JoinColumn(name = "banca_id")
    private List<Entrada> entradas;


}
