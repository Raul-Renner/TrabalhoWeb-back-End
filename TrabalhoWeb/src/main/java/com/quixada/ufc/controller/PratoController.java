package com.quixada.ufc.controller;


import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.quixada.ufc.model.Prato;
import com.quixada.ufc.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {
	
	@Autowired
	private PratoService pratoService;
	
	@RequestMapping("/formPrato")
	public ModelAndView formularioPrato() {
		ModelAndView mv = new ModelAndView("FormularioPrato");
		mv.addObject("prato", new Prato());
		return mv;
	}
	
	@PostMapping("/cadastrarPrato")
	public ModelAndView cadastroPrato(@Validated Prato prato,BindingResult result, @RequestParam(value = "imagem") MultipartFile imagem) {
		ModelAndView mv = new ModelAndView("FormularioPrato");
		
		if(result.hasErrors()) {
			return mv;
		}
		
		
		pratoService.cadastrarPrato(prato,imagem);
		mv.addObject("mensagem", "Prato cadastrado com sucesso");
		return mv;
	}
	
	@RequestMapping("/listarPratos")
	public ModelAndView listagemPratos() {
		List<Prato> pratos = pratoService.retornarPratos();
		ModelAndView mv = new ModelAndView("ListagemPratos");
		mv.addObject("listagemDePratos", pratos);
		
		return mv;
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo) {
		pratoService.excluir(codigo);
		ModelAndView mv = new ModelAndView("redirect:/prato/listarPratos");
		return mv;
	}
	
	@RequestMapping("/atualizar/{codigo}")
	public ModelAndView atualizar(@PathVariable Long codigo) {
		Prato prato = pratoService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView("FormularioPrato");
		mv.addObject("prato", prato);
		
		return mv;
	}
}
