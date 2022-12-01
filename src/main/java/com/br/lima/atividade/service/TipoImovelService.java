package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.entity.TipoImovel;
import com.br.lima.atividade.repository.TipoImovelRepository;

@Service
public class TipoImovelService {

    @Autowired
    private TipoImovelRepository tipoImovelRepository;

    public TipoImovel get(Long id) {
        Optional<TipoImovel> optional = tipoImovelRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new EntityNotFoundException("Tipo imóvel não encontrado.");
    }

    public List<TipoImovel> getAll() {
        return tipoImovelRepository.findAll();
    }

    public TipoImovel save(TipoImovel tipoImovel) {
        return tipoImovelRepository.save(tipoImovel);
    }

    public TipoImovel update(Long id, TipoImovel tipoImovel) {
        TipoImovel tipoImovelBanco = get(id);

        tipoImovelBanco.setTp_imovel(tipoImovel.getTp_imovel());

        return tipoImovelRepository.save(tipoImovelBanco);
    }

    public void delete(Long id){
        TipoImovel tipoImovel = get(id);

        tipoImovelRepository.deleteById(tipoImovel.getCd_tp_imovel());
    }
}
