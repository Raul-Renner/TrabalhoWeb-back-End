package com.quixada.ufc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quixada.ufc.model.Gerente;
import com.quixada.ufc.service.GerenteService;

@Controller
@RequestMapping("/gerente")
public class GerenteController {
	
	@Autowired
	private GerenteService gerenteService;
	
	@RequestMapping("/formularioGerente")
	public ModelAndView formularioGerente() {
		ModelAndView mv = new ModelAndView("FormularioGerente");
		mv.addObject("gerente", new Gerente());
		
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastroGerente(@Validated Gerente gerente,BindingResult result) {
		ModelAndView mv = new ModelAndView("FormularioGerente");
		if(result.hasErrors()) {
			return mv;
		}
		gerenteService.cadastrar(gerente);
		mv.addObject("mensagem","Gerente cadastrado com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listarGerente")
	public ModelAndView listagemGerentes() {
		List<Gerente> gerente = gerenteService.retornar();
		ModelAndView mv = new ModelAndView("ListaGerente");
		mv.addObject("ListaGerente", gerente);
		return mv;
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluirGerente(@PathVariable Long codigo) {
		gerenteService.excluir(codigo);
		ModelAndView mv = new ModelAndView("redirect:/gerente/listarGerente");
		
		return mv;
	}
	
	@RequestMapping("/atualizar/{codigo}")
	public ModelAndView atualizarDados(@PathVariable Long codigo) {
		Gerente gerente = (Gerente)gerenteService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView("FormularioGerente");
		mv.addObject("gerente",gerente);
		return mv;
	}
	
	public void cadastroGerenteGeral() {
		Gerente gerenteGeral = new Gerente();
		
		gerenteGeral.setNome("dudu");
		gerenteGeral.setCpf("999.999.999.10");
		gerenteGeral.setEmail("duduGerenteGeral@gmail.com");
		gerenteGeral.setLogin("duduPalmeiras");
		gerenteGeral.setSenha("palmeiras2019");
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yy");
		Date date = null;
		try {
			date = data.parse("10/01/1993");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gerenteGeral.setDataNascimento(date);
		
		gerenteService.cadastrar(gerenteGeral);
		
	}
	
}
