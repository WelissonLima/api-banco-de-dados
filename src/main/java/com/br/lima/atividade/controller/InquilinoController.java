package com.br.lima.atividade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.lima.atividade.model.entity.Inquilino;
import com.br.lima.atividade.service.InquilinoService;

@RestController
@RequestMapping(value = "/api/inquilino")
public class InquilinoController {

    private final InquilinoService inquilinoService;

    public InquilinoController(InquilinoService inquilinoService) {
        this.inquilinoService = inquilinoService;
    }

    @GetMapping
    public ResponseEntity<List<Inquilino>> getAllInquilino() {
        List<Inquilino> inquilinos = inquilinoService.getAll();

        return new ResponseEntity<List<Inquilino>>(inquilinos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Inquilino> getInquilino(@PathVariable Long id) {
        Inquilino inquilino = inquilinoService.get(id);

        return new ResponseEntity<Inquilino>(inquilino, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Inquilino> saveInquilino(@RequestBody Inquilino body) {
        Inquilino inquilino = inquilinoService.save(body);

        return new ResponseEntity<Inquilino>(inquilino, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Inquilino> updateInquilino(@PathVariable Long id, @RequestBody Inquilino body) {
        Inquilino inquilino = inquilinoService.update(id, body);

        return new ResponseEntity<Inquilino>(inquilino, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteInquilino(@PathVariable Long id) {
        inquilinoService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
