package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.entities.Funcionario;
import com.avenuecode.hotime.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Controller para {@link com.avenuecode.hotime.entities.Funcionario}
 *
 * @author Silas
 * @since 10/06/2017
 */
@RestController
public class FuncionarioController implements Serializable {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @RequestMapping(value = "/funcionario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @RequestMapping(value = "/funcionario/{funcionarioId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerfuncionario(@PathVariable Long funcionarioId) {
        funcionarioRepository.delete(funcionarioId);
    }

    @RequestMapping(value = "/funcionario/{funcionarioId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionario buscar(@PathVariable Long funcionarioId) {
        return funcionarioRepository.findOne(funcionarioId);
    }

    @RequestMapping(value = "/funcionarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Funcionario> buscarTodas() {
        return (List) funcionarioRepository.findAll();
    }
}
