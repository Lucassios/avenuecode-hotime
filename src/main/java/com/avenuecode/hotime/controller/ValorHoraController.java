package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.entities.ValorHora;
import com.avenuecode.hotime.repository.ValorHoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Controller para {@link ValorHora}
 *
 * @author Silas
 * @since 10/06/2017
 */
@RestController
public class ValorHoraController implements Serializable {

    @Autowired
    private ValorHoraRepository valorHoraRepository;


    @RequestMapping(value = "/valorHora", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ValorHora criarValorHora(@RequestBody ValorHora valorHora) {
        return valorHoraRepository.save(valorHora);
    }

    @RequestMapping(value = "/valorHora/{valorHoraId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerValorHora(@PathVariable Long valorHoraId) {
        valorHoraRepository.delete(valorHoraId);
    }

    @RequestMapping(value = "/valorHora/{valorHoraId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ValorHora buscar(@PathVariable Long valorHoraId) {
        return valorHoraRepository.findOne(valorHoraId);
    }

    @RequestMapping(value = "/valorHoras", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValorHora> buscarTodas() {
        return (List) valorHoraRepository.findAll();
    }
}
