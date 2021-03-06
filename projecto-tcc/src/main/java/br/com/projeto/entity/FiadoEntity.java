package br.com.projeto.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.projeto.comum.AppBaseEntity;
import br.com.projeto.types.TipoFiado;

@Entity
@Table(name = "TB_FIADO")
public class FiadoEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FIA_ID", nullable = false)
	private Long id;

	@ManyToOne(targetEntity = ClienteEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FIA_CLIID")
	private ClienteEntity cliente;

	@Column(name = "FIA_DESCRICAO", nullable = false, length = 60)
	private String descricao;

	@Column(name = "FIA_VALOR", nullable = false, length = 60)
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "FIA_TIPOFIADO")
	private TipoFiado tipoFiado;
	
	public FiadoEntity() {
	}

	public FiadoEntity(Long id, ClienteEntity cliente, String descricao, BigDecimal valor, TipoFiado tipoFiado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.descricao = descricao;
		this.valor = valor;
		this.tipoFiado = tipoFiado;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoFiado getTipoFiado() {
		return tipoFiado;
	}

	public void setTipoFiado(TipoFiado tipoFiado) {
		this.tipoFiado = tipoFiado;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiadoEntity other = (FiadoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
