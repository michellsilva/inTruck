package com.intruck.negocios;

import java.util.Date;
import java.util.List;

import com.intruck.entidades.Mercadoria;
import com.intruck.entidades.Trajeto;
import com.intruck.entidades.Veiculo;
import com.intruck.excessoes.MercadoriaExistenteException;
import com.intruck.excessoes.MercadoriaInexistenteException;
import com.intruck.excessoes.TrajetoExistenteException;
import com.intruck.excessoes.TrajetoInexistenteException;
import com.intruck.excessoes.VeiculoExistenteException;
import com.intruck.excessoes.VeiculoInexistenteException;
public interface Fachada {
	
	public void salvarVeiculo(Veiculo veiculo) throws VeiculoExistenteException;
	public void removerVeiculo(String email) throws VeiculoInexistenteException;
	public List<Veiculo> listarTodosVeiculos();
	public Veiculo buscarVeiculo(String placa) throws VeiculoInexistenteException;
	public List<Veiculo> buscarVeiculoMarca(String marca);
	
	public void salvarMercadoria(Mercadoria mercadoria) throws MercadoriaExistenteException;
	public void removerMercadoria(String email) throws MercadoriaInexistenteException;
	public List<Mercadoria> listarTodosMercadoria();
	public Mercadoria buscarMercadoria(String descricao) throws MercadoriaInexistenteException;
	public List<Mercadoria> buscarMercadoriaId(int id);
	
	public void salvarTrajeto(Trajeto trajeto) throws TrajetoExistenteException;
	public void removerTrajeto(int id) throws TrajetoInexistenteException;
	public List<Trajeto> listarTodosTrajeto();	
	public List<Trajeto> buscarTrajetoData(Date data);
	
	
	
}
