package com.ppedro.apigestaoentradas.api.domain;

import com.ppedro.apigestaoentradas.api.enums.Resultado;
import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "entrada")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Banca banca;
    private LocalDate dataEntrada;
    private String campeonato;
    private String timeCasa;
    private String timeFora;
    private Double valor;
    private Double odd;
    private Resultado resultado;

}
