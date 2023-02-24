package com.ppedro.apigestaoentradas.api.service;


import com.ppedro.apigestaoentradas.api.domain.Pessoa;
import com.ppedro.apigestaoentradas.api.domain.dtos.PessoaDTO;
import com.ppedro.apigestaoentradas.api.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    public Pessoa create(PessoaDTO pessoa) {
        if(pessoaRepository.findByCpf(pessoa.getCpf()).isPresent() ||
        pessoaRepository.findByEmail(pessoa.getEmail()).isPresent())
            throw new ObjectNotFoundException("Pessoa nao encontrada", pessoa);

        return pessoaRepository.save(new Pessoa(pessoa));
    }

    public Pessoa findById(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Pessoa nao encontrada", id));
    }
}
