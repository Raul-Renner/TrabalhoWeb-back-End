package com.quixada.ufc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quixada.ufc.model.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
