package com.avenuecode.hotime.repository;

import com.avenuecode.hotime.entities.Localidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lucascmarques on 10/06/17.
 */
@Repository
public interface LocalidadeRepository extends CrudRepository<Localidade, Long> {

}
