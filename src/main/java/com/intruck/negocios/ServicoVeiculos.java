package com.intruck.negocios;

import java.util.List;

import com.intruck.entidades.Veiculo;
import com.intruck.excessoes.VeiculoExistenteException;
import com.intruck.excessoes.VeiculoInexistenteException;

public interface ServicoVeiculos {
	
	public void salvarVeiculo(Veiculo veiculo) throws VeiculoExistenteException;
	public void removerVeiculo(String placa) throws VeiculoInexistenteException;
	public void removerVeiculo(Long id) throws VeiculoInexistenteException;
	public List<Veiculo> listarTodosVeiculos();
	public Veiculo buscarVeiculo(String placa) throws VeiculoInexistenteException;
	public List<Veiculo> buscarVeiculoMarca(String marca);
	public Veiculo buscarVeiculoId(Long id) throws VeiculoInexistenteException;
	
	
}

