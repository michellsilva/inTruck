package com.intruck.persistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.intruck.entidades.Mercadoria;

public interface RepositorioMercadorias extends CrudRepository<Mercadoria, Long>{
	
	public Mercadoria findByDescricao(String descricao);
	public List<Mercadoria> findByDescricaoContaining(String descricao);
	
	
	 
}
