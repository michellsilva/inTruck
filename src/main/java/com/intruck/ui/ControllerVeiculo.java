package com.intruck.ui;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intruck.entidades.Veiculo;
import com.intruck.excessoes.VeiculoExistenteException;
import com.intruck.negocios.Fachada;


@RequestMapping("/veiculos")
@RestController
public class ControllerVeiculo {
	@Autowired 	private Fachada fachada;
	private static Logger log = Logger.getLogger(ControllerVeiculo.class);

	@RequestMapping(method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  listarVeiculos(){
		try {
			return new ResponseEntity<List<Veiculo>>(fachada.listarTodosVeiculo(), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error("Erro ao retornar veiculos"), HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/salvar", method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody Veiculo veiculo){
		try {
			fachada.salvarVeiculo(veiculo);
			return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
		} catch (VeiculoExistenteException e) {
			return new ResponseEntity<Error>(new Error(e.getMessage()), HttpStatus.OK);
		}
	}		
}
