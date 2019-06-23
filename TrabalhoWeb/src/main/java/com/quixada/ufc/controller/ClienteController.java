package com.quixada.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quixada.ufc.model.Usuario;
import com.quixada.ufc.model.Cliente;
import com.quixada.ufc.service.ClienteService;
import com.quixada.ufc.service.UsuarioService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	
	@RequestMapping("/formulario")
	public ModelAndView formularioCliente() {
		ModelAndView mv = new ModelAndView("FormularioCliente");
		mv.addObject("cliente",new Cliente());
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastroCliente(@Validated Cliente cliente,BindingResult result) {
		ModelAndView mv = new ModelAndView("FormularioCliente");
		if(result.hasErrors()) {
			return mv;
		}
		clienteService.cadastrar(cliente);
		mv.addObject("mensagem","Pessoa cadastrado com sucesso!");
		return mv;
		
	}
	
	@RequestMapping("/listarClientes")
	public ModelAndView listagemClientes() {
		List<Cliente> clientes = clienteService.retornar();
		ModelAndView mv = new ModelAndView("PaginaListagemCliente");
		mv.addObject("listagemDeClientes", clientes);
		
		return mv;
		
	}
	
	@RequestMapping("/atualizar/{codigo}")
	public ModelAndView atualizar(@PathVariable Long codigo) {
		Cliente cliente = (Cliente)clienteService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView("FormularioCliente");
		mv.addObject("cliente", cliente);
		
		return mv;
		
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo) {
		clienteService.excluir(codigo);
		ModelAndView mv = new ModelAndView("redirect:/cliente/listarClientes");
		return mv;
		
	}
	
	
	
	@RequestMapping("/paginaInicial")
	public String pagina() {
		return "Index";
	}
	
	@RequestMapping("/")
	public ModelAndView pagInicial() {
		ModelAndView mv = new ModelAndView("Index");
		return mv;
}
		
	
}
