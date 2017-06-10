package com.avenuecode.hotime.controller;

import com.avenuecode.hotime.entities.Localidade;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lucascmarques on 10/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocalidadeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    public void criarLocalidade() {
        Localidade localidade = new Localidade();
    }

}
