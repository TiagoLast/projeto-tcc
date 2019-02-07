package br.com.projeto.facade;

import java.util.List;

import br.com.projeto.entity.ConsultaEntity;

public interface ConsultaFacade {
	
	public void save(ConsultaEntity consulta);
	
	public List<ConsultaEntity> all();

	public void remove(ConsultaEntity consulta);

	public List<ConsultaEntity> selected(String value);

	public ConsultaEntity get(Long id);

}
