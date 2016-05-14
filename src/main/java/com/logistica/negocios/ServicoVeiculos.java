package com.logistica.negocios;

import java.util.List;

import com.logistica.entidades.Veiculo;
import com.logistica.excessoes.VeiculoExistenteException;
import com.logistica.excessoes.VeiculoInexistenteException;

public interface ServicoVeiculos {
	
	public void salvar(Veiculo veiculo) throws VeiculoExistenteException;
	public void remover(String placa) throws VeiculoInexistenteException;
	public List<Veiculo> listarTodos();
	public Veiculo buscarPorPlaca(String placa) throws VeiculoInexistenteException;
	public List<Veiculo> buscarPorMarca(String marca);
	
}

