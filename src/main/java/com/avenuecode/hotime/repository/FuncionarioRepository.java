package com.avenuecode.hotime.repository;

import com.avenuecode.hotime.entities.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Silas
 * @since 10/06/2017
 */
@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

    Funcionario findByEmailAndSenha(String email, String senha);

}
