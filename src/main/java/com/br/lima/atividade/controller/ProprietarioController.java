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

import com.br.lima.atividade.model.entity.Proprietario;
import com.br.lima.atividade.service.ProprietarioService;

@RestController
@RequestMapping(value = "/api/proprietario")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

    @GetMapping
    public ResponseEntity<List<Proprietario>> getAllProprietario() {
        List<Proprietario> proprietarios = proprietarioService.getAll();

        return new ResponseEntity<List<Proprietario>>(proprietarios, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Proprietario> getProprietario(@PathVariable Long id) {
        Proprietario proprietario = proprietarioService.get(id);

        return new ResponseEntity<Proprietario>(proprietario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proprietario> saveProprietario(@RequestBody Proprietario body) {
        Proprietario proprietario = proprietarioService.save(body);

        return new ResponseEntity<Proprietario>(proprietario, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Proprietario> updateProprietario(@PathVariable Long id, @RequestBody Proprietario body) {
        Proprietario proprietario = proprietarioService.update(id, body);

        return new ResponseEntity<Proprietario>(proprietario, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProprietario(@PathVariable Long id) {
        proprietarioService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
