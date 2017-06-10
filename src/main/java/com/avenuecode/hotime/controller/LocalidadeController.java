package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.entities.Localidade;
import com.avenuecode.hotime.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lucascmarques on 10/06/17.
 */
@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Localidade criarLocalidade(@RequestBody Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    @DeleteMapping(value = "/{localidadeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerLocalidade(@PathVariable Long localidadeId) {
        localidadeRepository.delete(localidadeId);
    }

    @GetMapping(value = "/{localidadeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Localidade buscar(@PathVariable  Long localidadeId) {
        return localidadeRepository.findOne(localidadeId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Localidade> buscarTodas() {
        return (List) localidadeRepository.findAll();
    }

}
