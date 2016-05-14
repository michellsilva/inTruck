package com.logistica.negocios;

import java.util.Date;
import java.util.List;

import com.logistica.entidades.Trajeto;
import com.logistica.excessoes.TrajetoExistenteException;
import com.logistica.excessoes.TrajetoInexistenteException;

public interface ServicoTrajetos {
	
	public void salvar(Trajeto trajeto) throws TrajetoExistenteException;
	public void remover(Long id) throws TrajetoInexistenteException;
	public List<Trajeto> listarTodos();	
	public List<Trajeto> buscarPorData(Date data);
	public List<Trajeto> buscarPorIntervaloDeData(Date dataInicial, Date dataFinal);
	
}

