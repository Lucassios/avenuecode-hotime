package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.dto.ResponseGeoLocationDTO;
import com.avenuecode.hotime.entities.Localidade;
import com.avenuecode.hotime.repository.LocalidadeRepository;
import com.bytebybyte.google.geocoding.service.response.AddressComponent;
import com.bytebybyte.google.geocoding.service.response.Result;
import com.bytebybyte.google.geocoding.service.response.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by lucascmarques on 10/06/17.
 */
@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Localidade criarLocalidade(@RequestBody Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    @DeleteMapping(value = "/{localidadeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerLocalidade(@PathVariable Long localidadeId) {
        localidadeRepository.delete(localidadeId);
    }

    @GetMapping(value = "/{localidadeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Localidade buscar(@PathVariable Long localidadeId) {
        return localidadeRepository.findOne(localidadeId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Localidade> buscarTodas() {
        return (List) localidadeRepository.findAll();
    }

    @GetMapping(value = "latlng/{latlng}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Localidade obterLocalidadeLatitudeLongitude(@PathVariable String latlng) {

        ResponseEntity<ResponseGeoLocationDTO> forEntity = restTemplate.getForEntity(
                "https://maps.googleapis.com/maps/api/geocode/json?latlng=".concat(latlng), ResponseGeoLocationDTO.class);

        return localidadeRepository.findLocalidadeByCidadeContains(getNomeCidade(forEntity));
    }

    private String getNomeCidade(ResponseEntity<ResponseGeoLocationDTO> forEntity) {
        for (Result result : forEntity.getBody().results) {
            for (AddressComponent addressComponent : result.getAddressComponents()) {
                for (Type type : addressComponent.getTypes()) {
                    if (type.equals(Type.ADMINISTRATIVE_AREA_LEVEL_2)) {
                        return addressComponent.getLongName();
                    }
                }
            }
        }
        return null;
    }
}
