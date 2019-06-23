package com.quixada.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quixada.ufc.model.Cliente;
import com.quixada.ufc.model.Usuario;
import com.quixada.ufc.repositorio.ClienteRepositorio;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public void cadastrar(Cliente cliente) {
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		clienteRepositorio.save(cliente);
	}
	public List<Cliente> retornar(){
		return clienteRepositorio.findAll();
	}
	
	public void excluir(Long codigo) {
		clienteRepositorio.deleteById(codigo);
	}
	
	public Usuario buscarPorId(Long codigo) {
		return clienteRepositorio.getOne(codigo);
	}

}
