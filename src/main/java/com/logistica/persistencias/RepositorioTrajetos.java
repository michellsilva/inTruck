package com.logistica.persistencias;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.logistica.entidades.Trajeto;

public interface RepositorioTrajetos extends CrudRepository<Trajeto, Long>{
	
	public List<Trajeto> findByDataInclusao(Date date);
	public List<Trajeto> findByDataInclusaoBetween(Date dataInicial, Date dataFinal);
	
}
