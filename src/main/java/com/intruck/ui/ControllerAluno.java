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

import com.intruck.entidades.Aluno;



@RequestMapping("/veiculos")
@RestController
public class ControllerAluno {
//	@Autowired 	private Fachada fachada;
	private static Logger log = Logger.getLogger(ControllerAluno.class);

	@RequestMapping(method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  listarAlunos(){
		return null;
	}
	@RequestMapping(value = "/salvar", method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody Aluno aluno){
		return null;
	}		
}

