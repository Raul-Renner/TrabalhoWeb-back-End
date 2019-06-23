package com.quixada.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.quixada.ufc.model.Prato;
import com.quixada.ufc.repositorio.PratoRepositorio;
import com.quixada.ufc.util.AulaFileUtils;

@Service
public class PratoService {
	
	@Autowired
	private PratoRepositorio pratoRepositorio;
	
	public void cadastrarPrato(Prato prato, MultipartFile imagem) {
		String caminho = "images/" + prato.getNome() +".png";
		AulaFileUtils.salvarImagem(caminho, imagem);
		pratoRepositorio.save(prato);
	}
	
	public List<Prato> retornarPratos(){
		return pratoRepositorio.findAll();
	}
	
	public void excluir(Long codigo) {
		pratoRepositorio.deleteById(codigo);
	}
	
	public Prato buscarPorId(Long codigo) {
		return pratoRepositorio.getOne(codigo);
	}
}
