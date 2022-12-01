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

import com.br.lima.atividade.model.entity.DadosBancarios;
import com.br.lima.atividade.service.DadosBancariosService;

@RestController
@RequestMapping(value = "/api/dadosBancarios")
public class DadosBancariosController {

    private final DadosBancariosService dadosBancariosService;

    public DadosBancariosController(DadosBancariosService dadosBancariosService) {
        this.dadosBancariosService = dadosBancariosService;
    }

    @GetMapping
    public ResponseEntity<List<DadosBancarios>> getAllDadosBancarios() {
        List<DadosBancarios> dadosBancarios = dadosBancariosService.getAll();

        return new ResponseEntity<List<DadosBancarios>>(dadosBancarios, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DadosBancarios> getDadosBancarios(@PathVariable Long id) {
        DadosBancarios dadosBancarios = dadosBancariosService.get(id);

        return new ResponseEntity<DadosBancarios>(dadosBancarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DadosBancarios> saveDadosBancarios(@RequestBody DadosBancarios body) {
        DadosBancarios dadosBancarios = dadosBancariosService.save(body);

        return new ResponseEntity<DadosBancarios>(dadosBancarios, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DadosBancarios> updateDadosBancarios(@PathVariable Long id, @RequestBody DadosBancarios body) {
        DadosBancarios dadosBancarios = dadosBancariosService.update(id, body);

        return new ResponseEntity<DadosBancarios>(dadosBancarios, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDadosBancarios(@PathVariable Long id) {
        dadosBancariosService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
