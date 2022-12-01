package com.br.lima.atividade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.lima.atividade.model.dto.ContratoAluguelDTO;
import com.br.lima.atividade.model.entity.ContratoAluguel;
import com.br.lima.atividade.service.ContratoAluguelService;

@RestController
@RequestMapping(value = "/api/contratoAluguel")
public class ContratoAluguelController {

    private final ContratoAluguelService aluguelService;

    public ContratoAluguelController(ContratoAluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public ResponseEntity<List<ContratoAluguel>> getAllContratos() {
        List<ContratoAluguel> contratos = aluguelService.getAll();

        return new ResponseEntity<List<ContratoAluguel>>(contratos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContratoAluguel> getContratoAluguel(@PathVariable Long id) {
        ContratoAluguel contrato = aluguelService.get(id);

        return new ResponseEntity<ContratoAluguel>(contrato, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContratoAluguel> saveContratoAluguel(@RequestBody ContratoAluguelDTO body) {
        ContratoAluguel contrato = aluguelService.save(body);

        return new ResponseEntity<ContratoAluguel>(contrato, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContratoAluguel> updateContratoAluguel(@PathVariable Long id, @RequestBody ContratoAluguelDTO body) {
        ContratoAluguel contrato = aluguelService.update(id, body);

        return new ResponseEntity<ContratoAluguel>(contrato, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteContratoAluguel(@PathVariable Long id) {
        aluguelService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
