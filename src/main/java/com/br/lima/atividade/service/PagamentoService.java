package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.dto.PagamentoDTO;
import com.br.lima.atividade.model.entity.ContratoAluguel;
import com.br.lima.atividade.model.entity.Pagamento;
import com.br.lima.atividade.repository.ContratoAluguelRepository;
import com.br.lima.atividade.repository.PagamentoRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ContratoAluguelRepository contratoAluguelRepository;

    public Pagamento get(Long id) {
        Optional<Pagamento> optional = pagamentoRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new EntityNotFoundException("Pagamento não encontrado.");
    }

    public List<Pagamento> getAll() {
        return pagamentoRepository.findAll();
    }

    public Pagamento save(PagamentoDTO pagamentoDto) {
        Pagamento pagamento = pagamentoDto.toPagamento();
        Optional<ContratoAluguel> optional = contratoAluguelRepository.findById(pagamentoDto.getCd_contrato());

        if(!optional.isPresent()){
            throw new EntityNotFoundException("Contrato não encontrado.");
        }

        pagamento.setAluguel(optional.get());

        return pagamentoRepository.save(pagamento);
    }

    public Pagamento update(Long id, Pagamento pagamento) {
        Pagamento pagamentoBanco = get(id);

        if(pagamento.getDs_mes_ano() != null) pagamentoBanco.setDs_mes_ano(pagamento.getDs_mes_ano());
        if(pagamento.getDt_pagamento() != null) pagamentoBanco.setDt_pagamento(pagamento.getDt_pagamento());
        if(pagamento.getVl_pago() != null) pagamentoBanco.setVl_pago(pagamento.getVl_pago());

        return pagamentoRepository.save(pagamentoBanco);
    }

    public void delete(Long id){
        Pagamento pagamento = get(id);

        pagamentoRepository.deleteById(pagamento.getCd_pagamento());
    }
}
