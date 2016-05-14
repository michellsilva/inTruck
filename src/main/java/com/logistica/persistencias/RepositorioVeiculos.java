package com.logistica.persistencias;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.logistica.entidades.Veiculo;

public interface RepositorioVeiculos extends CrudRepository<Veiculo, Long>{
	
	public Veiculo findByPlaca(String placa);
	public List<Veiculo> findByMarca(String marca);
	
}
