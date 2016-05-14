package com.logistica.fachadas;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.entidades.Mercadoria;
import com.logistica.entidades.Trajeto;
import com.logistica.entidades.Veiculo;
import com.logistica.excessoes.MercadoriaExistenteException;
import com.logistica.excessoes.MercadoriaInexistenteException;
import com.logistica.excessoes.TrajetoExistenteException;
import com.logistica.excessoes.TrajetoInexistenteException;
import com.logistica.excessoes.VeiculoExistenteException;
import com.logistica.excessoes.VeiculoInexistenteException;
import com.logistica.negocios.ServicoMercadorias;
import com.logistica.negocios.ServicoTrajetos;
import com.logistica.negocios.ServicoVeiculos;

@Service
public class FachadaImpl implements Fachada {

	@Autowired
	private ServicoVeiculos servicoVeiculos;
	@Autowired
	private ServicoMercadorias servicoMercadorias;
	@Autowired
	private ServicoTrajetos servicoTrajetos;
	
	// Veiculos
	public void salvarVeiculo(Veiculo veiculo) throws VeiculoExistenteException {
		this.servicoVeiculos.salvar(veiculo);
	}
	public void removerVeiculo(String email) throws VeiculoInexistenteException {
		this.servicoVeiculos.remover(email);		
	}
	public List<Veiculo> listarTodosVeiculos() {
		return this.servicoVeiculos.listarTodos();
	}
	public Veiculo buscarVeiculoPorPlaca(String placa) throws VeiculoInexistenteException {
		return this.servicoVeiculos.buscarPorPlaca(placa);
	}
	public List<Veiculo> buscarVeiculoPelaMarca(String marca) {
		return this.servicoVeiculos.buscarPorMarca(marca);
	}

	// Mercadoria
	public void salvarMercadoria(Mercadoria mercadoria) throws MercadoriaExistenteException {
		this.servicoMercadorias.salvar(mercadoria);
	}
	public void removerMercadoria(Long id) throws MercadoriaInexistenteException {
		this.servicoMercadorias.remover(id);
	}
	public List<Mercadoria> listarTodasMercadorias() {
		return this.servicoMercadorias.listarTodas();
	}
	public Mercadoria buscarMercadoriaPelaDescricao(String descricao) throws MercadoriaInexistenteException {
		return this.servicoMercadorias.buscarPorDescricao(descricao);
	}
	public List<Mercadoria> buscarMercadoriaContendoNaDescricao(String descricao) throws MercadoriaInexistenteException {
		return this.servicoMercadorias.buscarContendoNaDescricao(descricao);
	}
	public Mercadoria buscarMercadoriaPorId(Long id) {
		return this.servicoMercadorias.buscarPorId(id);
	}

	// Trajeto
	public void salvarTrajeto(Trajeto trajeto) throws TrajetoExistenteException {
		this.servicoTrajetos.salvar(trajeto);		
	}
	public void removerTrajeto(Long id) throws TrajetoInexistenteException {
		this.servicoTrajetos.remover(id);		
	}
	public List<Trajeto> listarTodosTrajetos() {
		return this.servicoTrajetos.listarTodos();
	}
	public List<Trajeto> buscarTrajetoPorData(Date data) {
		return this.servicoTrajetos.buscarPorData(data);
	}
	public List<Trajeto> buscarTrajetoPorIntervaloDeData(Date dataInicial, Date dataFinal) {
		return this.servicoTrajetos.buscarPorIntervaloDeData(dataInicial, dataFinal);
	}

}
