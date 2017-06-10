package com.avenuecode.hotime.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Silas
 * @since 10/06/2017
 */
@Entity
@Table
public class HorasTrabalhada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column
    private Date data;

    @Temporal(TemporalType.TIME)
    @Column
    private Date horas;

    @Temporal(TemporalType.TIME)
    @Column
    private Date horasExtras;


    public HorasTrabalhada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHoras() {
        return horas;
    }

    public void setHoras(Date horas) {
        this.horas = horas;
    }

    public Date getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Date horasExtras) {
        this.horasExtras = horasExtras;
    }
}
