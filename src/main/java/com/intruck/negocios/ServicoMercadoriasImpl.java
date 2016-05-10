package com.intruck.negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intruck.entidades.Mercadoria;
import com.intruck.excessoes.MercadoriaExistenteException;
import com.intruck.excessoes.MercadoriaInexistenteException;
import com.intruck.persistencia.RepositorioMercadorias;

@Service
public class ServicoMercadoriasImpl implements ServicoMercadorias {
	@Autowired
	private RepositorioMercadorias mercadorias;

	@Override
	public void salvarMercadoria(Mercadoria mercadoria) throws MercadoriaExistenteException {
		this.mercadorias.save(mercadoria);
	}

	@Override
	public void removerMercadoria(Long id) throws MercadoriaInexistenteException {
		Mercadoria mercadoria = this.mercadorias.findOne(id);
		if (mercadoria == null) {
			throw new MercadoriaInexistenteException();
		}
		this.mercadorias.delete(mercadoria);
	}

	@Override
	public List<Mercadoria> listarTodosMercadoria() {
		return (List<Mercadoria>) this.mercadorias.findAll();
	}

	@Override
	public Mercadoria buscarMercadoria(String descricao) throws MercadoriaInexistenteException {
		return this.mercadorias.findByDescricao(descricao);
	}

	@Override
	public Mercadoria buscarMercadoriaId(Long id) {
		return this.mercadorias.findOne(id);
	}

	@Override
	public List<Mercadoria> buscarMercadoriaContem(String descricao) throws MercadoriaInexistenteException {
		return this.mercadorias.findByDescricaoContaining(descricao);
	}

}
