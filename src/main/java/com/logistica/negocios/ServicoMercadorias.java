package com.logistica.negocios;

import java.util.List;

import com.logistica.entidades.Mercadoria;
import com.logistica.excessoes.MercadoriaExistenteException;
import com.logistica.excessoes.MercadoriaInexistenteException;

public interface ServicoMercadorias {

	public void salvar(Mercadoria mercadoria) throws MercadoriaExistenteException;
	public void remover(Long id) throws MercadoriaInexistenteException;
	public List<Mercadoria> listarTodas();
	public Mercadoria buscarPorDescricao(String descricao) throws MercadoriaInexistenteException;
	public List<Mercadoria> buscarContendoNaDescricao(String descricao) throws MercadoriaInexistenteException;
	public Mercadoria buscarPorId(Long id);
	
}
