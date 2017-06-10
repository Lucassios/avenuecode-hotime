package com.avenuecode.hotime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avenuecode.hotime.entities.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {

}
