package com.intruck.negocios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intruck.entidades.Trajeto;
import com.intruck.excessoes.TrajetoExistenteException;
import com.intruck.excessoes.TrajetoInexistenteException;
import com.intruck.persistencia.RepositorioTrajetos;

@Service
public class ServicoTrajetosImpl implements ServicoTrajetos {
	@Autowired private RepositorioTrajetos trajetos;		
	@Override
	public void salvarTrajeto(Trajeto trajeto) throws TrajetoExistenteException {		
		this.trajetos.save(trajeto);				
	}

	@Override
	public void removerTrajeto(Long id) throws TrajetoInexistenteException {
		Trajeto trajeto = this.trajetos.findOne(id); 
		if(trajeto != null){
			this.trajetos.delete(trajeto);			
		}
	}

	@Override
	public List<Trajeto> listarTodosTrajeto() {
		return (List<Trajeto>)this.trajetos.findAll();
	}

	@Override
	public List<Trajeto> buscarTrajetoData(Date data) {
		return this.trajetos.findByDtInclusao(data);		
	}	

	@Override
	public List<Trajeto> buscarDtInclusaoIntervalo(Date dtInicial, Date dtFinal) {
		return this.trajetos.findByDtInclusaoBetween(dtInicial, dtFinal);	
	}
	
	

}
