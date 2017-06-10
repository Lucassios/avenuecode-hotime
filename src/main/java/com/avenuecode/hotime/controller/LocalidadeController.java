package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.entities.Localidade;
import com.avenuecode.hotime.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lucascmarques on 10/06/17.
 */
@RestController
public class LocalidadeController {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    public Localidade criarLocalidade(Localidade localidade) {
        Localidade localidadeSaved = localidadeRepository.save(localidade);
        return localidadeSaved;
    }

}
