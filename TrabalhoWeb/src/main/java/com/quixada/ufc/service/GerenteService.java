package com.quixada.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quixada.ufc.model.Gerente;
import com.quixada.ufc.model.Role;
import com.quixada.ufc.model.Usuario;
import com.quixada.ufc.repositorio.GerenteRepositorio;
import com.quixada.ufc.repositorio.RoleRepositorio;

@Service
public class GerenteService {
	@Autowired
	private GerenteRepositorio gerenteRepositorio;
	
//	@Autowired
//	private RoleService roleServico;
	public void cadastrar(Gerente gerente) {
		// gerente.setRoles(roleServico.buscarPorId("GERENTE"));
		
		gerente.setSenha(new BCryptPasswordEncoder().encode(gerente.getSenha()));
		gerenteRepositorio.save(gerente);
	}
	public List<Gerente> retornar(){
		return gerenteRepositorio.findAll();
	}
	
	public void excluir(Long codigo) {
		gerenteRepositorio.deleteById(codigo);
	}
	
	public Usuario buscarPorId(Long codigo) {
		return gerenteRepositorio.getOne(codigo);
	}

}
