package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.entities.HoraTrabalhada;
import com.avenuecode.hotime.repository.HoraTrabalhadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lucascmarques on 10/06/17.
 */
@RestController
public class HoraTrabalhadaController {

    @Autowired
    private HoraTrabalhadaRepository horaTrabalhadaRepository;

    @RequestMapping(value = "/horatrabalhada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HoraTrabalhada criar(@RequestBody HoraTrabalhada horaTrabalhada) {
        return horaTrabalhadaRepository.save(horaTrabalhada);
    }

    @RequestMapping(value = "/horatrabalhada/{horaTrabalhadaId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void remover(@PathVariable Long horaTrabalhadaId) {
        horaTrabalhadaRepository.delete(horaTrabalhadaId);
    }

    @RequestMapping(value = "/horatrabalhada/{horaTrabalhadaId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HoraTrabalhada buscar(@PathVariable  Long horaTrabalhadaId) {
        return horaTrabalhadaRepository.findOne(horaTrabalhadaId);
    }

    @RequestMapping(value = "/horatrabalhada", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HoraTrabalhada> buscarTodas() {
        return (List) horaTrabalhadaRepository.findAll();
    }

}
