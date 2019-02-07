package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.PersistenceUtils;
import br.com.projeto.dao.QueryUtils;
import br.com.projeto.entity.LancamentoEntity;
import br.com.projeto.facade.AppBO;

@ApplicationScoped
public class LancamentoBO implements Serializable, AppBO<LancamentoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<LancamentoEntity> query;
		
	@Inject
	private PersistenceUtils<LancamentoEntity> dao;

	@Override
	public void save(LancamentoEntity lancamento) {
		dao.save(lancamento);
	}

	@Override
	public void remove(LancamentoEntity lancamento) {
		dao.remove(lancamento);
	}

	@Override
	public List<LancamentoEntity> all() {
		return query.all(LancamentoEntity.class);
	}

	@Override
	public List<LancamentoEntity> selected(String value) {
		return query.recuperaItem(LancamentoEntity.class, value, "titulo");
	}

	@Override
	public LancamentoEntity get(Long idLancamento) {
		return query.get(LancamentoEntity.class, idLancamento);
	}

}
