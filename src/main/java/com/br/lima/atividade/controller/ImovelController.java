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

import com.br.lima.atividade.model.dto.ImovelDTO;
import com.br.lima.atividade.model.entity.Imovel;
import com.br.lima.atividade.service.ImovelService;

@RestController
@RequestMapping(value = "/api/imovel")
public class ImovelController {

    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping
    public ResponseEntity<List<Imovel>> getAllImoveis() {
        List<Imovel> imoveis = imovelService.getAll();

        return new ResponseEntity<List<Imovel>>(imoveis, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Imovel> getImovel(@PathVariable Long id) {
        Imovel imovel = imovelService.get(id);

        return new ResponseEntity<Imovel>(imovel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Imovel> saveImovel(@RequestBody ImovelDTO body) {
        Imovel imovel = imovelService.save(body);

        return new ResponseEntity<Imovel>(imovel, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Imovel> updateImovel(@PathVariable Long id, @RequestBody Imovel body) {
        Imovel imovel = imovelService.update(id, body);

        return new ResponseEntity<Imovel>(imovel, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteImovel(@PathVariable Long id) {
        imovelService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
