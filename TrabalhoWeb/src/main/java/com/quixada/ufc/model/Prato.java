package com.quixada.ufc.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Prato {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long codigo;

@NotBlank(message = "Preencha o nome do prato")
private String nome;

@NotNull(message = "Indique o valor do prato")
private double preco;

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
}
public Long getCodigo() {
	return codigo;
}
public void setCodigo(Long codigo) {
	this.codigo = codigo;
}



}
