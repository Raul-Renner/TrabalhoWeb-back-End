package com.quixada.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quixada.ufc.model.Role;
import com.quixada.ufc.repositorio.RoleRepositorio;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepositorio roleRepositorio;
	
	public void cadastrarPrato(Role role) {
		roleRepositorio.save(role);
	}
	
	public List<Role> retornarRoles(){
		return roleRepositorio.findAll();
	}

	public Role buscarPorId(String role) {
		return roleRepositorio.getOne(role);
	}
	
}
