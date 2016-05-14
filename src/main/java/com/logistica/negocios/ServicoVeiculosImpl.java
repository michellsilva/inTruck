package com.logistica.negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.entidades.Veiculo;
import com.logistica.excessoes.VeiculoExistenteException;
import com.logistica.excessoes.VeiculoInexistenteException;
import com.logistica.persistencias.RepositorioVeiculos;

@Service
public class ServicoVeiculosImpl implements ServicoVeiculos {
	
	@Autowired
	private RepositorioVeiculos repositorio;

	public void salvar(Veiculo veiculo) throws VeiculoExistenteException {
		this.repositorio.save(veiculo);
	}

	public void remover(String placa) throws VeiculoInexistenteException {
		Veiculo veiculo = this.buscarPorPlaca(placa);
		if (veiculo != null) {
			this.repositorio.delete(veiculo);
		}
		throw new VeiculoInexistenteException();
	}

	public List<Veiculo> listarTodos() {
		return (List<Veiculo>) this.repositorio.findAll(); 
	}

	public Veiculo buscarPorPlaca(String placa) throws VeiculoInexistenteException {
		return this.repositorio.findByPlaca(placa);		
	}

	public List<Veiculo> buscarPorMarca(String marca) {
		return this.repositorio.findByMarca(marca);	
	}
	
}
