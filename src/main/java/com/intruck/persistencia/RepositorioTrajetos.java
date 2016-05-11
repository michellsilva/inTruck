package com.intruck.persistencia;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;

import com.intruck.entidades.Trajeto;

public interface RepositorioTrajetos extends CrudRepository<Trajeto, Long>{
	public List<Trajeto> findByDtInclusao (@Temporal(TemporalType.DATE) Date date);
	public List<Trajeto> findByDtInclusaoBetween(Date dtInicial, Date dtFinal );
	public List<Trajeto> filtroTrajeto(Date dtInicial, Date dtFinal, Long trajetoId, int status, long mercadoriaId);
	
}
