package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.entity.DadosBancarios;
import com.br.lima.atividade.model.entity.Proprietario;
import com.br.lima.atividade.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Proprietario get(Long id) {
        Optional<Proprietario> optional = proprietarioRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new EntityNotFoundException("Proprietário não encontrado.");
    }

    public List<Proprietario> getAll() {
        return proprietarioRepository.findAll();
    }

    public Proprietario save(Proprietario proprietario) {

        return proprietarioRepository.save(proprietario);
    }

    public Proprietario update(Long id, Proprietario proprietario) {
        Proprietario proprietarioBanco = get(id);
        
        if(proprietario.getCpf() != null) proprietarioBanco.setCpf(proprietario.getCpf());
        if(proprietario.getNm_proprietario() != null) proprietarioBanco.setNm_proprietario(proprietario.getNm_proprietario());
        
        if(proprietarioBanco.getDadosBancarios() != null){
            DadosBancarios dadosBancariosBanco = proprietarioBanco.getDadosBancarios();

            dadosBancariosBanco.setAgencia(proprietario.getDadosBancarios().getAgencia());
            dadosBancariosBanco.setBanco(proprietario.getDadosBancarios().getBanco());
            dadosBancariosBanco.setConta(proprietario.getDadosBancarios().getConta());    

            proprietarioBanco.setDadosBancarios(dadosBancariosBanco);
        }

        return proprietarioRepository.save(proprietarioBanco);
    }

    public void delete(Long id){
        Proprietario proprietario = get(id);

        proprietarioRepository.deleteById(proprietario.getCd_proprietario());
    }
}
