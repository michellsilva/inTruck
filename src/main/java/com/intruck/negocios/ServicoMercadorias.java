package com.intruck.negocios;

import java.util.List;

import com.intruck.entidades.Mercadoria;
import com.intruck.excessoes.MercadoriaExistenteException;
import com.intruck.excessoes.MercadoriaInexistenteException;

public interface ServicoMercadorias {

	public void salvarMercadoria(Mercadoria mercadoria) throws MercadoriaExistenteException;
	public void removerMercadoria(Long id) throws MercadoriaInexistenteException;
	public List<Mercadoria> listarTodosMercadoria();
	public Mercadoria buscarMercadoria(String descricao) throws MercadoriaInexistenteException;
	public List<Mercadoria> buscarMercadoriaContem(String descricao ) throws MercadoriaInexistenteException;
	public Mercadoria buscarMercadoriaId(Long id);
	
	
}
