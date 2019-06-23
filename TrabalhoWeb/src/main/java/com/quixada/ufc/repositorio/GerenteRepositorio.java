package com.quixada.ufc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quixada.ufc.model.Gerente;

@Repository
public interface GerenteRepositorio extends JpaRepository<Gerente, Long>{

}
