package com.ppedro.apigestaoentradas.api.service;


import com.ppedro.apigestaoentradas.api.domain.Banca;
import com.ppedro.apigestaoentradas.api.domain.Pessoa;
import com.ppedro.apigestaoentradas.api.domain.dtos.BancaDTO;
import com.ppedro.apigestaoentradas.api.repository.BancaRepository;
import com.ppedro.apigestaoentradas.api.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BancaService {

    private final BancaRepository bancaRepository;

    private final PessoaRepository pessoaRepository;

    public Banca create(BancaDTO bancaDTO){
        Pessoa pessoa = pessoaRepository.findById(bancaDTO.getIdPessoa())
                .orElseThrow(()-> new ObjectNotFoundException("Pessoa nao encontrada", bancaDTO.getIdPessoa()));;
        if(Objects.nonNull(pessoa.getBanca()))
            throw new RuntimeException();

        Banca banca = Banca.builder()
                .nome(bancaDTO.getNome())
                .valorInicial(bancaDTO.getValorInicial())
                .valorAtual(bancaDTO.getValorInicial())
                .entradas(new ArrayList<>())
                .build();

        pessoa.setBanca(banca);
        pessoaRepository.save(pessoa);

        return bancaRepository.save(banca);
    }

}
