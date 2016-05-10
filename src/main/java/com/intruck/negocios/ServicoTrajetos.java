package com.intruck.negocios;

import java.util.Date;
import java.util.List;

import com.intruck.entidades.Trajeto;
import com.intruck.entidades.Veiculo;
import com.intruck.excessoes.TrajetoExistenteException;
import com.intruck.excessoes.TrajetoInexistenteException;
import com.intruck.excessoes.VeiculoExistenteException;
import com.intruck.excessoes.VeiculoInexistenteException;

public interface ServicoTrajetos {
	
	public void salvarTrajeto(Trajeto trajeto) throws TrajetoExistenteException;
	public void removerTrajeto(Long id) throws TrajetoInexistenteException;
	public List<Trajeto> listarTodosTrajeto();	
	public List<Trajeto> buscarTrajetoData(Date data);
	public List<Trajeto> buscarDtInclusaoIntervalo(Date dtInicial, Date dtFinal );
	
	
}

