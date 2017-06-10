package com.avenuecode.hotime.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe para mapeamento da tabela CARGO
 *
 * @author Silas
 * @since 10/06/2017
 */
@Entity
@Table
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    public Cargo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
