package com.avenuecode.hotime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avenuecode.hotime.entities.Cargo;
import com.avenuecode.hotime.repository.CargoRepository;

@RestController
public class CargoController {
	
    @Autowired
    private CargoRepository cargoRepository;

    @RequestMapping(value = "/cargo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cargo criarCargo(@RequestBody Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @RequestMapping(value = "/cargo/{cargoId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerCargo(@PathVariable Long cargoId) {
        cargoRepository.delete(cargoId);
    }

    @RequestMapping(value = "/cargo/{cargoId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cargo buscar(@PathVariable  Long cargoId) {
        return cargoRepository.findOne(cargoId);
    }

    @RequestMapping(value = "/cargos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cargo> buscarTodas() {
        return (List) cargoRepository.findAll();
    }

}
