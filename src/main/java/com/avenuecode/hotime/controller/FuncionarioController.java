package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.entities.Funcionario;
import com.avenuecode.hotime.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para {@link com.avenuecode.hotime.entities.Funcionario}
 *
 * @author Silas
 * @since 10/06/2017
 */
@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @RequestMapping(value = "/{funcionarioId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerfuncionario(@PathVariable Long funcionarioId) {
        funcionarioRepository.delete(funcionarioId);
    }

    @RequestMapping(value = "/{funcionarioId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionario buscar(@PathVariable Long funcionarioId) {
        return funcionarioRepository.findOne(funcionarioId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Funcionario> buscarTodas() {
        return (List) funcionarioRepository.findAll();
    }
}
