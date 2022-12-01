package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.entity.DadosBancarios;
import com.br.lima.atividade.repository.DadosBancariosRepository;

@Service
public class DadosBancariosService {

    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;

    public DadosBancarios get(Long id) {
        Optional<DadosBancarios> optional = dadosBancariosRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new EntityNotFoundException("Dado bancários não encontrado.");
    }

    public List<DadosBancarios> getAll() {
        return dadosBancariosRepository.findAll();
    }

    public DadosBancarios save(DadosBancarios dadosBancarios) {
        return dadosBancariosRepository.save(dadosBancarios);
    }

    public DadosBancarios update(Long id, DadosBancarios dadosBancarios) {
        DadosBancarios dadosBancariosBanco = get(id);

        dadosBancariosBanco.setAgencia(dadosBancarios.getAgencia());
        dadosBancariosBanco.setBanco(dadosBancarios.getBanco());
        dadosBancariosBanco.setConta(dadosBancarios.getConta());

        return dadosBancariosRepository.save(dadosBancariosBanco);
    }

    public void delete(Long id){
        DadosBancarios dadosBancarios = get(id);

        dadosBancariosRepository.deleteById(dadosBancarios.getCd_dados_bancarios());
    }
}
