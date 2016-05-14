package com.logistica.controles;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.logistica.entidades.Veiculo;
import com.logistica.excessoes.VeiculoExistenteException;
import com.logistica.excessoes.VeiculoInexistenteException;
import com.logistica.fachadas.Error;
import com.logistica.fachadas.Fachada;

@Controller
@RequestMapping("/veiculo")
public class ControleVeiculo {

	@Autowired
	private Fachada fachada;
	
	static Logger escreve = Logger.getLogger(ControleVeiculo.class);
	
	@RequestMapping(method = RequestMethod.GET)
    public String inicializar(ModelMap model) {
		System.out.println("Chamando o metodo inicializar do controle de veiculo");
		model.addAttribute("titulo_pagina", "InTruck [Veículo] - Serviços de Tranportes");
		model.addAttribute("titulo", "Manutenção dos Veículos");
		model.addAttribute("descricao", "Informações dos veiculos que são autorizados a realizar os transportes das mercadorias");
		model.addAttribute("titulo_formulario", "Dados do Cadastro");
		model.addAttribute("titulo_listagem", "Listagem");
		model.addAttribute("link_voltar", "");
		model.addAttribute("texto_voltar", "Voltar");
		return "veiculo";
    }
	
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(Veiculo veiculo) {
		System.out.println("Utilizando o metodo salvar no controle de veiculo");
    	try {
			fachada.salvarVeiculo(veiculo);
		} catch (VeiculoExistenteException e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
        return new ResponseEntity<Veiculo>(HttpStatus.OK);
	}
	
    @RequestMapping(value = "/remover/{placa}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remover(String placa) {
		System.out.println("Utilizando o metodo remover no controle de veiculo");
        try {
			fachada.removerVeiculo(placa);
		} catch (VeiculoInexistenteException e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
        return new ResponseEntity<Veiculo>(HttpStatus.OK);
	}
	
    @RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Veiculo>> listarTodos() {
		System.out.println("Utilizando o metodo listar todos no controle de veiculo");
        List<Veiculo> trajetos = fachada.listarTodosVeiculos();
        return new ResponseEntity<List<Veiculo>>(trajetos, HttpStatus.OK);
	}
	
    @RequestMapping(value = "/buscarPorPlaca/{placa}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorPlaca(@PathVariable("placa") String placa) {
		System.out.println("Utilizando o metodo buscar por placa no controle de veiculo");
		try {
			return new ResponseEntity<Veiculo>(fachada.buscarVeiculoPorPlaca(placa), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
	}
	
    @RequestMapping(value = "/buscarPorMarca/{marca}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPelaMarca(@PathVariable("marca") String marca) {
		System.out.println("Utilizando o metodo buscar pela marca no controle de veiculo");
		try {
			return new ResponseEntity<List<Veiculo>>(fachada.buscarVeiculoPelaMarca(marca), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error(1, e.getMessage()), HttpStatus.OK);
		}
	}
	
}
