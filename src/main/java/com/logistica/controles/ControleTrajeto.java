package com.logistica.controles;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.logistica.entidades.Trajeto;
import com.logistica.excessoes.TrajetoExistenteException;
import com.logistica.excessoes.TrajetoInexistenteException;
import com.logistica.fachadas.Error;
import com.logistica.fachadas.Fachada;

@Controller
@RequestMapping("/trajeto")
public class ControleTrajeto {

	@Autowired
	private Fachada fachada;
	
	static Logger escreve = Logger.getLogger(ControleTrajeto.class);
	
	@RequestMapping(method = RequestMethod.GET)
    public String inicializar(ModelMap model) {
		System.out.println("Chamando o metodo inicializar do controle de trajeto");
		model.addAttribute("titulo_pagina", "InTruck [Trajeto] - Serviços de Tranportes");
		model.addAttribute("titulo", "Manutenção dos Trajetos");
		model.addAttribute("descricao", "Informações das rotas que serão executadas");
		model.addAttribute("titulo_formulario", "Dados do Cadastro");
		model.addAttribute("titulo_listagem", "Listagem");
		model.addAttribute("link_voltar", "");
		model.addAttribute("texto_voltar", "Voltar");
		return "trajeto";
    }
	
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Trajeto trajeto) {
		System.out.println("Utilizando o metodo salvar no controle de trajeto");
    	try {
			fachada.salvarTrajeto(trajeto);
		} catch (TrajetoExistenteException e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
        return new ResponseEntity<Trajeto>(HttpStatus.OK);
	}
    
    @RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remover(@PathVariable("id") Long id) {
		System.out.println("Utilizando o metodo remover no controle de trajeto");
        try {
			fachada.removerTrajeto(id);
		} catch (TrajetoInexistenteException e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
        return new ResponseEntity<Trajeto>(HttpStatus.OK);
	}
	
    @RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<?> listarTodos() {
		System.out.println("Utilizando o metodo listar todos no controle de trajeto");
        List<Trajeto> trajetos = fachada.listarTodosTrajetos();
        return new ResponseEntity<List<Trajeto>>(trajetos, HttpStatus.OK);
	}
	
    @RequestMapping(value = "/buscarPorData/{data}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorData(@PathVariable("data") Date data) {
		System.out.println("Utilizando o metodo buscar por data no controle de trajeto");
		try {
			return new ResponseEntity<List<Trajeto>>(fachada.buscarTrajetoPorData(data), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
	}
	
    @RequestMapping(value = "/buscarPorDataInclusaoIntervalo/{dataInicial}&{dataFinal}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorIntervaloDeData(@PathVariable("dataInicial") Date dataInicial, @PathVariable("dataFinal") Date dataFinal) {
		System.out.println("Utilizando o metodo buscar por intervalo de data no controle de trajeto");
		try {
			return new ResponseEntity<List<Trajeto>>(fachada.buscarTrajetoPorIntervaloDeData(dataInicial, dataFinal), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
	}
	
}
