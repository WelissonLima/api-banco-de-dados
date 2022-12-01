package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.dto.ImovelDTO;
import com.br.lima.atividade.model.entity.Endereco;
import com.br.lima.atividade.model.entity.Imovel;
import com.br.lima.atividade.model.entity.Proprietario;
import com.br.lima.atividade.model.entity.TipoImovel;
import com.br.lima.atividade.repository.ImovelRepository;
import com.br.lima.atividade.repository.ProprietarioRepository;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Imovel get(Long id) {
        Optional<Imovel> optional = imovelRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new EntityNotFoundException("Imóvel não encontrado.");
    }

    public List<Imovel> getAll() {
        return imovelRepository.findAll();
    }

    public Imovel save(ImovelDTO imovelNovo) {
        Imovel imovel = imovelNovo.toImovel();
        Optional<Proprietario> optional = proprietarioRepository.findById(imovelNovo.getCd_proprietario());

        if(!optional.isPresent()){
            throw new EntityNotFoundException("Proprietário não encontrado.");
        }

        imovel.setProprietario(optional.get());

        return imovelRepository.save(imovel);
    }

    public Imovel update(Long id, Imovel imovelNovo) {
        Imovel imovelBanco = get(id);

        if(imovelNovo.getQtd_quartos() != null) imovelBanco.setQtd_quartos(imovelNovo.getQtd_quartos());
        if(imovelNovo.getQtd_banheiros() != null) imovelBanco.setQtd_banheiros(imovelNovo.getQtd_banheiros());
        
        if(imovelNovo.getEndereco() != null){
            Endereco enderecoNovo = imovelNovo.getEndereco();
            Endereco enderecoBanco = imovelBanco.getEndereco();

            if(enderecoNovo.getCep() != null) enderecoBanco.setCep(enderecoNovo.getCep());
            if(enderecoNovo.getBairro() != null) enderecoBanco.setBairro(enderecoNovo.getBairro());
            if(enderecoNovo.getCidade() != null) enderecoBanco.setCidade(enderecoNovo.getCidade());
            if(enderecoNovo.getComplemento() != null) enderecoBanco.setComplemento(enderecoNovo.getComplemento());
            if(enderecoNovo.getLogradouro() != null) enderecoBanco.setLogradouro(enderecoNovo.getLogradouro());
            if(enderecoNovo.getUf() != null) enderecoBanco.setUf(enderecoNovo.getUf());

            imovelBanco.setEndereco(enderecoBanco);
        }

        if(imovelNovo.getTipoImovel() != null){
            TipoImovel tipoImovelNovo = imovelNovo.getTipoImovel();
            TipoImovel tipoImovelBanco = imovelBanco.getTipoImovel();

            if(tipoImovelNovo.getTp_imovel() != null) tipoImovelBanco.setTp_imovel(tipoImovelNovo.getTp_imovel());

            imovelBanco.setTipoImovel(tipoImovelBanco);
        }

        return imovelRepository.save(imovelBanco);
    }

    public void delete(Long id){
        Imovel imovel = get(id);

        imovelRepository.deleteById(imovel.getCd_imovel());
    }
}
