package com.logistica.controles;

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

import com.logistica.entidades.Mercadoria;
import com.logistica.excessoes.MercadoriaExistenteException;
import com.logistica.excessoes.MercadoriaInexistenteException;
import com.logistica.fachadas.Error;
import com.logistica.fachadas.Fachada;

@Controller
@RequestMapping("/mercadoria")
public class ControleMercadoria {

	@Autowired
	private Fachada fachada;
	
	static Logger escreve = Logger.getLogger(ControleMercadoria.class);
	
	@RequestMapping(method = RequestMethod.GET)
    public String inicializar(ModelMap model) {
		System.out.println("Chamando o metodo inicializar do controle de mercadoria");
/*		model.addAttribute("titulo_pagina", "InTruck [Mercadoria] - Serviços de Tranportes");
		model.addAttribute("titulo", "Manutenção das Mercadorias");
		model.addAttribute("descricao", "Informações dos mercadorias que serão tranportadas");
		model.addAttribute("titulo_formulario", "Dados do Cadastro");
		model.addAttribute("titulo_listagem", "Listagem");
		model.addAttribute("link_voltar", "");
		model.addAttribute("texto_voltar", "Voltar");
*/		return "mercadoria";
    }
	
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Mercadoria mercadoria) {
		System.out.println("Utilizando o metodo salvar no controle de mercadoria");
    	try {
			fachada.salvarMercadoria(mercadoria);
		} catch (MercadoriaExistenteException e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
        return new ResponseEntity<Mercadoria>(HttpStatus.OK);
	}
	
    @RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remover(@PathVariable("id") Long id) {
		System.out.println("Utilizando o metodo remover no controle de mercadoria");
        try {
			fachada.removerMercadoria(id);
		} catch (MercadoriaInexistenteException e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
        return new ResponseEntity<Mercadoria>(HttpStatus.OK);
	}
	
    @RequestMapping(value = "/listarTodas", method = RequestMethod.GET)
	public ResponseEntity<List<Mercadoria>> listarTodas() {
		System.out.println("Utilizando o metodo listar todas no controle de mercadoria");
        List<Mercadoria> mercadorias = fachada.listarTodasMercadorias();
        return new ResponseEntity<List<Mercadoria>>(mercadorias, HttpStatus.OK);
	}
	
    @RequestMapping(value = "/buscarPorDescricao/{descricao}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorDescricao(@PathVariable("descricao") String descricao) {
		System.out.println("Utilizando o metodo buscar por descrição no controle de mercadoria");
		try {
			return new ResponseEntity<Mercadoria>(fachada.buscarMercadoriaPelaDescricao(descricao), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
	}
	
    @RequestMapping(value = "/buscarContendoNaDescricao/{descricao}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarContendoNaDescricao(@PathVariable("descricao") String descricao) {
		System.out.println("Utilizando o metodo buscar contendo na descricao no controle de mercadoria");
		try {
			return new ResponseEntity<List<Mercadoria>>(fachada.buscarMercadoriaContendoNaDescricao(descricao), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
	}
	
    @RequestMapping(value = "/buscarPorId/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
		System.out.println("Utilizando o metodo buscar por id no controle de mercadoria");
		try {
			return new ResponseEntity<Mercadoria>(fachada.buscarMercadoriaPorId(id), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
	}
	
}
