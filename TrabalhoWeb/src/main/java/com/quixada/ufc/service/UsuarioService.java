package com.quixada.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quixada.ufc.model.Usuario;
import com.quixada.ufc.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio pessoaRepositorio;
	
	public void cadastrar(Usuario usuario) {
		pessoaRepositorio.save(usuario);
	}
	
	public List<Usuario> retornar(){
		return pessoaRepositorio.findAll();
	}
	
	public void excluir(Long codigo) {
		pessoaRepositorio.deleteById(codigo);
	}
	
	public Usuario buscarPorId(Long codigo) {
		return pessoaRepositorio.getOne(codigo);
	}
	
}
