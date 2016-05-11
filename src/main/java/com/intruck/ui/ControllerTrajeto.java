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

import com.intruck.entidades.Trajeto;
import com.intruck.excessoes.TrajetoExistenteException;
import com.intruck.negocios.Fachada;



@RequestMapping("/veiculos")
@RestController
public class ControllerTrajeto {
	@Autowired 	private Fachada fachada;
	private static Logger log = Logger.getLogger(ControllerTrajeto.class);

	@RequestMapping(method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  listarTrajetos(){
		try {
			return new ResponseEntity<List<Trajeto>>(fachada.listarTodosTrajeto(), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error("deu um burro aqui"), HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/salvar", method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody Trajeto trajeto){
		try {
			fachada.salvarTrajeto(trajeto);
			return new ResponseEntity<Trajeto>(trajeto, HttpStatus.OK);
		} catch (TrajetoExistenteException e) {
			return new ResponseEntity<Error>(new Error(e.getMessage()), HttpStatus.OK);
		}
	}		
}
