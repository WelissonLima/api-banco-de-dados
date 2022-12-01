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

import com.br.lima.atividade.model.dto.PagamentoDTO;
import com.br.lima.atividade.model.entity.Pagamento;
import com.br.lima.atividade.service.PagamentoService;

@RestController
@RequestMapping(value = "/api/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> getAllInquilino() {
        List<Pagamento> pagamentos = pagamentoService.getAll();

        return new ResponseEntity<List<Pagamento>>(pagamentos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pagamento> getInquilino(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.get(id);

        return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pagamento> saveInquilino(@RequestBody PagamentoDTO body) {
        Pagamento pagamento = pagamentoService.save(body);

        return new ResponseEntity<Pagamento>(pagamento, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pagamento> updateInquilino(@PathVariable Long id, @RequestBody Pagamento body) {
        Pagamento pagamento = pagamentoService.update(id, body);

        return new ResponseEntity<Pagamento>(pagamento, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteInquilino(@PathVariable Long id) {
        pagamentoService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
