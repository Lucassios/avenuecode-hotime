package com.avenuecode.hotime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avenuecode.hotime.entities.Cargo;
import com.avenuecode.hotime.repository.CargoRepository;

@RestController
@RequestMapping(value = "/cargo")
public class CargoController {
	
    @Autowired
    private CargoRepository cargoRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Cargo criarCargo(@RequestBody Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @DeleteMapping(value = "/{cargoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerCargo(@PathVariable Long cargoId) {
        cargoRepository.delete(cargoId);
    }

    @GetMapping(value = "/{cargoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cargo buscarCargo(@PathVariable  Long cargoId) {
        return cargoRepository.findOne(cargoId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cargo> buscarTodos() {
        return (List) cargoRepository.findAll();
    }
}