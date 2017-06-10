package com.avenuecode.hotime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lucascmarques on 10/06/17.
 */
@SpringBootApplication
public class HotimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotimeApplication.class, args);
    }

    @Bean
    public RestTemplate setup(RestTemplateBuilder builder) {
        return builder.build();
    }

}
