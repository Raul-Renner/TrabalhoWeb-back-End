package com.quixada.ufc.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.quixada.ufc.model.Usuario;
import com.quixada.ufc.repositorio.UsuarioRepositorio;

@Repository
@Transactional
public class UserDetailsImplements implements UserDetailsService{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Usuario usuario =usuarioRepositorio.findByCpf(cpf);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Cliente nao encontrado!!");
		}
		
		return new User(usuario.getUsername(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
	}

}
