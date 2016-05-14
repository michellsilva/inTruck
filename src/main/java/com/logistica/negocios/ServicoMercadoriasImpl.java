package com.logistica.negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.entidades.Mercadoria;
import com.logistica.excessoes.MercadoriaExistenteException;
import com.logistica.excessoes.MercadoriaInexistenteException;
import com.logistica.persistencias.RepositorioMercadorias;

@Service
public class ServicoMercadoriasImpl implements ServicoMercadorias {
	
	@Autowired
	private RepositorioMercadorias repositorio;

	public void salvar(Mercadoria mercadoria) throws MercadoriaExistenteException {
		this.repositorio.save(mercadoria);
	}

	public void remover(Long id) throws MercadoriaInexistenteException {
		Mercadoria mercadoria = this.repositorio.findOne(id);
		if (mercadoria == null) {
			throw new MercadoriaInexistenteException();
		}
		this.repositorio.delete(mercadoria);
	}

	public List<Mercadoria> listarTodas() {
		return (List<Mercadoria>) this.repositorio.findAll();
	}

	public Mercadoria buscarPorDescricao(String descricao) throws MercadoriaInexistenteException {
		return this.repositorio.findByDescricao(descricao);
	}

	public List<Mercadoria> buscarContendoNaDescricao(String descricao) throws MercadoriaInexistenteException {
		return this.repositorio.findByDescricaoContaining(descricao);
	}

	public Mercadoria buscarPorId(Long id) {
		return this.repositorio.findOne(id);
	}

}
