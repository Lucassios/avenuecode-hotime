package com.avenuecode.hotime.repository;

import com.avenuecode.hotime.entities.ValorHora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Silas
 * @since 10/06/2017
 */
@Repository
public interface ValorHoraRepository extends CrudRepository<ValorHora, Long> {
}
