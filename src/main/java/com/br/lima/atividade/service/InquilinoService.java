package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.entity.Inquilino;
import com.br.lima.atividade.repository.InquilinoRepository;

@Service
public class InquilinoService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    public Inquilino get(Long id) {
        Optional<Inquilino> optional = inquilinoRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new EntityNotFoundException("Inquilino não encontrado.");
    }

    public List<Inquilino> getAll() {
        return inquilinoRepository.findAll();
    }

    public Inquilino save(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }

    public Inquilino update(Long id, Inquilino inquilino) {
        Inquilino inquilinoBanco = get(id);

        if(inquilino.getCpf() != null) inquilinoBanco.setCpf(inquilino.getCpf());
        if(inquilino.getNm_inquilino() != null) inquilinoBanco.setNm_inquilino(inquilino.getNm_inquilino());

        return inquilinoRepository.save(inquilinoBanco);
    }

    public void delete(Long id){
        Inquilino inquilino = get(id);

        inquilinoRepository.deleteById(inquilino.getCd_inquilino());
    }
}
