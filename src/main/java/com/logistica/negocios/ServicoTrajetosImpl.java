package com.logistica.negocios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.entidades.Trajeto;
import com.logistica.excessoes.TrajetoExistenteException;
import com.logistica.excessoes.TrajetoInexistenteException;
import com.logistica.persistencias.RepositorioTrajetos;

@Service
public class ServicoTrajetosImpl implements ServicoTrajetos {
	
	@Autowired
	private RepositorioTrajetos repositorio;
	
	public void salvar(Trajeto trajeto) throws TrajetoExistenteException {		
		this.repositorio.save(trajeto);				
	}

	public void remover(Long id) throws TrajetoInexistenteException {
		Trajeto trajeto = this.repositorio.findOne(id); 
		if (trajeto != null) {
			this.repositorio.delete(trajeto);			
		}
	}

	public List<Trajeto> listarTodos() {
		return (List<Trajeto>)this.repositorio.findAll();
	}

	public List<Trajeto> buscarPorData(Date data) {
		return this.repositorio.findByDataInclusao(data);		
	}	

	public List<Trajeto> buscarPorIntervaloDeData(Date dataInicial, Date dataFinal) {
		return this.repositorio.findByDataInclusaoBetween(dataInicial, dataFinal);	
	}

}
