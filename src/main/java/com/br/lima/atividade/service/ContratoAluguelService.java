package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.dto.ContratoAluguelDTO;
import com.br.lima.atividade.model.entity.ContratoAluguel;
import com.br.lima.atividade.model.entity.Imovel;
import com.br.lima.atividade.model.entity.Inquilino;
import com.br.lima.atividade.repository.ContratoAluguelRepository;
import com.br.lima.atividade.repository.ImovelRepository;
import com.br.lima.atividade.repository.InquilinoRepository;

@Service
public class ContratoAluguelService {

    @Autowired
    private ContratoAluguelRepository aluguelRepository;

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Autowired
    private ImovelRepository imovelRepository;

    public ContratoAluguel get(Long id) {
        Optional<ContratoAluguel> optional = aluguelRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new EntityNotFoundException("Contrato de aluguel não encontrado.");
    }

    public List<ContratoAluguel> getAll() {
        return aluguelRepository.findAll();
    }

    public ContratoAluguel save(ContratoAluguelDTO aluguel) {
        ContratoAluguel contratoAluguel = new ContratoAluguel();
        Optional<Inquilino> optionalInquilino = inquilinoRepository.findById(aluguel.getCd_inquilino());
        Optional<Imovel> optionalImovel = imovelRepository.findById(aluguel.getCd_imovel());

        if(!optionalInquilino.isPresent()){
            throw new EntityNotFoundException("Inquilino não encontrado.");
        }

        if(!optionalImovel.isPresent()){
            throw new EntityNotFoundException("Imóvel não encontrado.");
        }
        
        contratoAluguel = aluguel.toContratoAluguel();
        contratoAluguel.setInquilino(optionalInquilino.get());
        contratoAluguel.setImovel(optionalImovel.get());

        return aluguelRepository.save(contratoAluguel);
    }

    public ContratoAluguel update(Long id, ContratoAluguelDTO aluguel) {
        ContratoAluguel aluguelBanco = get(id);

        if(aluguel.getDt_fim() != null) aluguelBanco.setDt_fim(aluguel.getDt_fim());
        if(aluguel.getDt_inicio() != null) aluguelBanco.setDt_inicio(aluguel.getDt_inicio());
        if(aluguel.getVl_aluguel() != null) aluguelBanco.setVl_aluguel(aluguel.getVl_aluguel());
        if(aluguel.getDt_contrato() != null) aluguelBanco.setDt_contrato(aluguel.getDt_contrato());

        return aluguelRepository.save(aluguelBanco);
    }

    public void delete(Long id){
        ContratoAluguel aluguel = get(id);

        aluguelRepository.deleteById(aluguel.getCd_contrato());
    }
}
