package com.avenuecode.hotime.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Silas
 * @since 10/06/2017
 */
@Entity
@Table
public class ValorHora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private BigDecimal valorHora;

    @Column
    private BigDecimal valorExtra;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Localidade localidade;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Cargo cargo;

    public ValorHora() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
