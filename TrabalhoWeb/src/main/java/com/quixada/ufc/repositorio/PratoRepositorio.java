package com.quixada.ufc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quixada.ufc.model.Prato;

@Repository
public interface PratoRepositorio extends JpaRepository<Prato, Long>{
	//Prato findByLogin(String login);
}
