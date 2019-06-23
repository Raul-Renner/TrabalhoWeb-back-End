package com.quixada.ufc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quixada.ufc.model.Role;

public interface RoleRepositorio extends JpaRepository<Role, String>{
	
}
