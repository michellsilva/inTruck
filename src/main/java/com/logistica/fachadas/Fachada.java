package com.logistica.fachadas;

import java.util.Date;
import java.util.List;

import com.logistica.entidades.Mercadoria;
import com.logistica.entidades.Trajeto;
import com.logistica.entidades.Veiculo;
import com.logistica.excessoes.MercadoriaExistenteException;
import com.logistica.excessoes.MercadoriaInexistenteException;
import com.logistica.excessoes.TrajetoExistenteException;
import com.logistica.excessoes.TrajetoInexistenteException;
import com.logistica.excessoes.VeiculoExistenteException;
import com.logistica.excessoes.VeiculoInexistenteException;

public interface Fachada {
	
	public void salvarVeiculo(Veiculo veiculo) throws VeiculoExistenteException;
	public void removerVeiculo(String email) throws VeiculoInexistenteException;
	public List<Veiculo> listarTodosVeiculos();
	public Veiculo buscarVeiculoPorPlaca(String placa) throws VeiculoInexistenteException;
	public List<Veiculo> buscarVeiculoPelaMarca(String marca);
	
	public void salvarMercadoria(Mercadoria mercadoria) throws MercadoriaExistenteException;
	public void removerMercadoria(Long id) throws MercadoriaInexistenteException;
	public List<Mercadoria> listarTodasMercadorias();
	public Mercadoria buscarMercadoriaPelaDescricao(String descricao) throws MercadoriaInexistenteException;
	public List<Mercadoria> buscarMercadoriaContendoNaDescricao(String descricao) throws MercadoriaInexistenteException;
	public Mercadoria buscarMercadoriaPorId(Long id);
	
	public void salvarTrajeto(Trajeto trajeto) throws TrajetoExistenteException;
	public void removerTrajeto(Long id) throws TrajetoInexistenteException;
	public List<Trajeto> listarTodosTrajetos();	
	public List<Trajeto> buscarTrajetoPorData(Date data);
	public List<Trajeto> buscarTrajetoPorIntervaloDeData(Date dataInicial, Date dataFinal);
	
}
