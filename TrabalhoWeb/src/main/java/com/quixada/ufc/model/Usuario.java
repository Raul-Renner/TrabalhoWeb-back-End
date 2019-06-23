package com.quixada.ufc.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long codigo;

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
		name = "pessoas_roles",
		joinColumns = @JoinColumn(
			name = "pessoas_codigo",referencedColumnName = "codigo"),
			inverseJoinColumns = @JoinColumn(
					name = "role_codigo",referencedColumnName = "papel"
					)
				)

private List<Role>roles;
		
@NotBlank(message = "Preencha seu nome")
private String nome;

@NotBlank(message = "Preencha seu cpf")
private String cpf;

@NotBlank(message = "Preencha seu email")
private String email;


private String login;
private String senha;

@DateTimeFormat(pattern = "dd/MM/yyyy")
@Temporal(TemporalType.DATE)
private Date dataNascimento;

public Long getCodigo() {
	return codigo;
}
public void setCodigo(Long codigo) {
	this.codigo = codigo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}

public Date getDataNascimento() {
	return dataNascimento;
}
public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return (Collection<? extends GrantedAuthority>)this.roles ;
}
@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return this.senha;
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return this.login;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}	
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}


}
