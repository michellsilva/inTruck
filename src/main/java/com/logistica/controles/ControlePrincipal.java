package com.logistica.controles;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ControlePrincipal {

	static Logger escreve = Logger.getLogger(ControlePrincipal.class);
	
	@RequestMapping(method = RequestMethod.GET)
    public String inicializar() {
		System.out.println("Chamando o metodo inicializar do controle principal");
		return "principal";
    }
	
}
