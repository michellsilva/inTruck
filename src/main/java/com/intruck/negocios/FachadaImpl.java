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

	@Autowired
	private ServicoVeiculos veiculos;
	@Autowired
	private ServicoMercadorias mercadorias;
	@Autowired
	private ServicoTrajetos trajetos;

	@Override
	public void salvarVeiculo(Veiculo veiculo) throws VeiculoExistenteException {
		this.veiculos.salvarVeiculo(veiculo);
	}

	@Override
	public void removerVeiculo(Long id) throws VeiculoInexistenteException {
		this.veiculos.removerVeiculo(id);		
	}

	@Override
	public void removerVeiculo(String placa) throws VeiculoInexistenteException {
		this.veiculos.removerVeiculo(placa);
		
	}

	@Override
	public List<Veiculo> listarTodosVeiculo() {
		return this.veiculos.listarTodosVeiculos();
	}

	@Override
	public Veiculo buscarVeiculo(String placa) throws VeiculoInexistenteException {
		return this.veiculos.buscarVeiculo(placa);
	}

	@Override
	public List<Veiculo> buscarVeiculoMarca(String marca) {
		return this.veiculos.buscarVeiculoMarca(marca);
	}


	@Override
	public Veiculo buscarVeiculoId(Long id) throws VeiculoInexistenteException {
		return this.veiculos.buscarVeiculoId(id);
	}

	@Override
	public void salvarMercadoria(Mercadoria mercadoria) throws MercadoriaExistenteException {
		this.mercadorias.salvarMercadoria(mercadoria);
		
	}

	@Override
	public void removerMercadoria(Long id) throws MercadoriaInexistenteException {
		this.mercadorias.removerMercadoria(id);		
	}

	@Override
	public List<Mercadoria> listarTodosMercadoria() {
		return this.mercadorias.listarTodosMercadoria();
	}

	@Override
	public Mercadoria buscarMercadoria(String descricao) throws MercadoriaInexistenteException {
		return this.mercadorias.buscarMercadoria(descricao);
	}

	@Override
	public Mercadoria buscarMercadoriaId(Long id) {
		return this.mercadorias.buscarMercadoriaId(id);
	}

	@Override
	public List<Mercadoria> ordenarMercadoriaDistancia(int[] ids) {
		return this.mercadorias.ordenarMercadoriaDistancia(ids);
	}

	@Override
	public void salvarTrajeto(Trajeto trajeto) throws TrajetoExistenteException {
		this.trajetos.salvarTrajeto(trajeto);
		
	}

	@Override
	public void removerTrajeto(Long id) throws TrajetoInexistenteException {
		this.trajetos.removerTrajeto(id);
		
	}

	@Override
	public List<Trajeto> listarTodosTrajeto() {
		return this.trajetos.listarTodosTrajeto();
	}

	@Override
	public List<Trajeto> buscarTrajetoData(Date data) {
		return this.trajetos.buscarTrajetoData(data);
	}

	@Override
	public Trajeto buscarTrajetoId(Long id) {
		return this.trajetos.buscarTrajetoId(id);
	}

	@Override
	public List<Trajeto> filtroTrajeto(Date dtInicial, Date dtFinal, Long trajetoId, int status, long mercadoriaId) {
		return this.trajetos.filtroTrajeto(dtInicial, dtFinal, trajetoId, status, mercadoriaId);
	}

}
