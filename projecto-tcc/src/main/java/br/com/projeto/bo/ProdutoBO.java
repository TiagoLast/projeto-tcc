package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.PersistenceUtils;
import br.com.projeto.dao.QueryUtils;
import br.com.projeto.entity.ProdutoEntity;
import br.com.projeto.facade.AppBO;

@ApplicationScoped
public class ProdutoBO implements Serializable, AppBO<ProdutoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private PersistenceUtils<ProdutoEntity> dao;

	@Inject
	private QueryUtils<ProdutoEntity> query;

	@Override
	public void save(ProdutoEntity produto) {
		dao.save(produto);
	}

	@Override
	public void remove(ProdutoEntity produto) {
		dao.remove(produto);
	}

	@Override
	public ProdutoEntity get(Long id) {
		return query.get(ProdutoEntity.class, id);
	}

	@Override
	public List<ProdutoEntity> all() {
		return query.all(ProdutoEntity.class);
	}

	@Override
	public List<ProdutoEntity> selected(String value) {
		return query.recuperaItem(ProdutoEntity.class, value, "nome");
	}

	public ProdutoEntity recuperaProduto(Long id) {
		return query.get(ProdutoEntity.class, id);
	}

}
