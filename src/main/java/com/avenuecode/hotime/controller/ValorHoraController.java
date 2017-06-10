package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.entities.ValorHora;
import com.avenuecode.hotime.repository.ValorHoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para {@link ValorHora}
 *
 * @author Silas
 * @since 10/06/2017
 */
@RestController
@RequestMapping(value = "/valorHora")
public class ValorHoraController {

    @Autowired
    private ValorHoraRepository valorHoraRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ValorHora criarValorHora(@RequestBody ValorHora valorHora) {
        return valorHoraRepository.save(valorHora);
    }

    @DeleteMapping(value = "/{valorHoraId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerValorHora(@PathVariable Long valorHoraId) {
        valorHoraRepository.delete(valorHoraId);
    }

    @GetMapping(value = "/{valorHoraId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ValorHora buscar(@PathVariable Long valorHoraId) {
        return valorHoraRepository.findOne(valorHoraId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValorHora> buscarTodas() {
        return (List) valorHoraRepository.findAll();
    }
}
