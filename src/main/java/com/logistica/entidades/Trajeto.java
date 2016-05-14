package com.logistica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trajeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	// Trabalhando unidirecional
	@OneToOne(fetch = FetchType.LAZY)
	private Veiculo veiculo;

	// Trabalhando unidirecional
	@ManyToMany
	@JoinTable(name="trajeto_has_mercadoria", joinColumns={@JoinColumn(name="trajeto_id")}, inverseJoinColumns={@JoinColumn(name="mercadoria_id")})
	private List<Mercadoria> mercadorias;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInclusao;

	private String tempoPrevisto;
	private String tempoReal;
	private int status;

	public Trajeto() {
		super();
	}

	public Trajeto(Long id, Veiculo veiculo, List<Mercadoria> mercadorias, Date dataInclusao, String tempoPrevisto,
			String tempoReal, int status) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.mercadorias = mercadorias;
		this.dataInclusao = dataInclusao;
		this.tempoPrevisto = tempoPrevisto;
		this.tempoReal = tempoReal;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Mercadoria> getMercadorias() {
		return mercadorias;
	}

	public void setMercadorias(List<Mercadoria> mercadorias) {
		this.mercadorias = mercadorias;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getTempoPrevisto() {
		return tempoPrevisto;
	}

	public void setTempoPrevisto(String tempoPrevisto) {
		this.tempoPrevisto = tempoPrevisto;
	}

	public String getTempoReal() {
		return tempoReal;
	}

	public void setTempoReal(String tempoReal) {
		this.tempoReal = tempoReal;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInclusao == null) ? 0 : dataInclusao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mercadorias == null) ? 0 : mercadorias.hashCode());
		result = prime * result + status;
		result = prime * result + ((tempoPrevisto == null) ? 0 : tempoPrevisto.hashCode());
		result = prime * result + ((tempoReal == null) ? 0 : tempoReal.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		Trajeto other = (Trajeto) obj;
		if (dataInclusao == null) {
			if (other.dataInclusao != null)
				return false;
		} else if (!dataInclusao.equals(other.dataInclusao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mercadorias == null) {
			if (other.mercadorias != null)
				return false;
		} else if (!mercadorias.equals(other.mercadorias))
			return false;
		if (status != other.status)
			return false;
		if (tempoPrevisto == null) {
			if (other.tempoPrevisto != null)
				return false;
		} else if (!tempoPrevisto.equals(other.tempoPrevisto))
			return false;
		if (tempoReal == null) {
			if (other.tempoReal != null)
				return false;
		} else if (!tempoReal.equals(other.tempoReal))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trajeto [id=" + id + ", veiculo=" + veiculo + ", mercadorias=" + mercadorias + ", dataInclusao="
				+ dataInclusao + ", tempoPrevisto=" + tempoPrevisto + ", tempoReal=" + tempoReal + ", status=" + status
				+ "]";
	}

}
