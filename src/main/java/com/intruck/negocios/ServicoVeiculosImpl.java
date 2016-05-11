package com.intruck.negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intruck.entidades.Veiculo;
import com.intruck.excessoes.VeiculoExistenteException;
import com.intruck.excessoes.VeiculoInexistenteException;
import com.intruck.persistencia.RepositorioVeiculos;

@Service
public class ServicoVeiculosImpl implements ServicoVeiculos {
	@Autowired
	private RepositorioVeiculos veiculos;

	@Override
	public void salvarVeiculo(Veiculo veiculo) throws VeiculoExistenteException {
		this.veiculos.save(veiculo);
	}

	@Override
	public void removerVeiculo(String placa) throws VeiculoInexistenteException {
		Veiculo veiculo = this.buscarVeiculo(placa);
		if(veiculo!=null){
			this.veiculos.delete(veiculo);
		}
		throw new VeiculoInexistenteException();
	}

	@Override
	public List<Veiculo> listarTodosVeiculos() {
		return (List<Veiculo>)this.veiculos.findAll(); 
	}

	@Override
	public Veiculo buscarVeiculo(String placa) throws VeiculoInexistenteException {
		return this.veiculos.findByPlaca(placa);		
	}

	@Override
	public List<Veiculo> buscarVeiculoMarca(String marca) {
		return this.veiculos.findByMarca(marca);	
	}

	@Override
	public void removerVeiculo(Long id) throws VeiculoInexistenteException {
		this.veiculos.delete(id);
		
	}

	@Override
	public Veiculo buscarVeiculoId(Long id) throws VeiculoInexistenteException {
		return this.veiculos.findOne(id);
	}
}
