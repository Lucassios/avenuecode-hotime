package com.avenuecode.hotime.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lucascmarques on 10/06/17.
 */
@Entity
public class Localidade {

    @Id
    @GeneratedValue
    private Long id;

}
