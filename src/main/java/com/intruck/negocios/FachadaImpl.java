package com.intruck.negocios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intruck.entidades.Mercadoria;
import com.intruck.entidades.Trajeto;
import com.intruck.entidades.Veiculo;
import com.intruck.excessoes.MercadoriaExistenteException;
import com.intruck.excessoes.MercadoriaInexistenteException;
import com.intruck.excessoes.TrajetoExistenteException;
import com.intruck.excessoes.TrajetoInexistenteException;
import com.intruck.excessoes.VeiculoExistenteException;
import com.intruck.excessoes.VeiculoInexistenteException;

@Service
public class FachadaImpl implements Fachada {

	@Autowired 	private ServicoVeiculos veiculos;
	@Autowired 	private ServicoMercadorias mercadorias;
	@Autowired 	private ServicoTrajetos trajetos;
	
	@Override
	public void salvarVeiculo(Veiculo veiculo) throws VeiculoExistenteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removerVeiculo(String email) throws VeiculoInexistenteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Veiculo> listarTodosVeiculos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Veiculo buscarVeiculo(String placa) throws VeiculoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Veiculo> buscarVeiculoMarca(String marca) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarMercadoria(Mercadoria mercadoria) throws MercadoriaExistenteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removerMercadoria(String email) throws MercadoriaInexistenteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Mercadoria> listarTodosMercadoria() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Mercadoria buscarMercadoria(String descricao) throws MercadoriaInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Mercadoria> buscarMercadoriaId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarTrajeto(Trajeto trajeto) throws TrajetoExistenteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removerTrajeto(int id) throws TrajetoInexistenteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Trajeto> listarTodosTrajeto() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Trajeto> buscarTrajetoData(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
