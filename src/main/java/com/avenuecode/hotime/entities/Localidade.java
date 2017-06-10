package com.avenuecode.hotime.entities;

import javax.persistence.*;

/**
 * Created by lucascmarques on 10/06/17.
 */
@Entity
@Table
public class Localidade {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String cidade;

    @Column
    private String pais;

    public Localidade() {
    }

    public Localidade(String cidade, String pais) {
        this.cidade = cidade;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
