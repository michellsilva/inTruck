package com.logistica.persistencias;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.logistica.entidades.Mercadoria;

public interface RepositorioMercadorias extends CrudRepository<Mercadoria, Long>{
	
	public Mercadoria findByDescricao(String descricao);
	public List<Mercadoria> findByDescricaoContaining(String descricao);
	 
}
