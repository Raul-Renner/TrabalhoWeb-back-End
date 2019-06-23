//package com.quixada.ufc.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.quixada.ufc.model.Prato;
//import com.quixada.ufc.service.PratoService;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.quixada.ufc.model.Prato;
//import com.quixada.ufc.service.PratoService;
//
//@Controller
//public class PedidoController {
//	@Autowired
//	private PratoService pratoService;
//	@RequestMapping("/")
//	public ModelAndView listagemPratos() {
//		List<Prato> pratos = pratoService.retornarPratos();
//		ModelAndView mv = new ModelAndView("Index");
//		mv.addObject("listagemDePedidos", pratos);
//		
//		return mv;
//	
//}
//}	
