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

import com.br.lima.atividade.model.entity.TipoImovel;
import com.br.lima.atividade.service.TipoImovelService;

@RestController
@RequestMapping(value = "/api/tipoImovel")
public class TipoImovelController {

    private final TipoImovelService tipoImovelService;

    public TipoImovelController(TipoImovelService tipoImovelService) {
        this.tipoImovelService = tipoImovelService;
    }

    @GetMapping
    public ResponseEntity<List<TipoImovel>> getAllTipoImovel() {
        List<TipoImovel> tipoImoveis = tipoImovelService.getAll();

        return new ResponseEntity<List<TipoImovel>>(tipoImoveis, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoImovel> getTipoImovel(@PathVariable Long id) {
        TipoImovel tipoImovel = tipoImovelService.get(id);

        return new ResponseEntity<TipoImovel>(tipoImovel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoImovel> saveTipoImovel(@RequestBody TipoImovel body) {
        TipoImovel tipoImovel = tipoImovelService.save(body);

        return new ResponseEntity<TipoImovel>(tipoImovel, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoImovel> updateTipoImovel(@PathVariable Long id, @RequestBody TipoImovel body) {
        TipoImovel tipoImovel = tipoImovelService.update(id, body);

        return new ResponseEntity<TipoImovel>(tipoImovel, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTipoImovel(@PathVariable Long id) {
        tipoImovelService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
