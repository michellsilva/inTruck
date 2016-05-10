package com.intruck.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trajeto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private Veiculo veiculo;
	
	@ManyToMany
	private List<Mercadoria> mercadorias;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtInclusao;
	
	private String tempoPrevisto;
	private String tempoReal;
	private int status;
	
	public Trajeto(){
	
	}
	public Trajeto(Long id, Veiculo veiculo, List<Mercadoria> mercadorias, Date dtInclusao, String tempoPrevisto,
			String tempoReal, int status) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.mercadorias = mercadorias;
		this.dtInclusao = dtInclusao;
		this.tempoPrevisto = tempoPrevisto;
		this.tempoReal = tempoReal;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public List<Mercadoria> getMercadorias() {
		return mercadorias;
	}
	public Date getDtInclusao() {
		return dtInclusao;
	}
	public String getTempoPrevisto() {
		return tempoPrevisto;
	}
	public String getTempoReal() {
		return tempoReal;
	}
	public int getStatus() {
		return status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public void setMercadorias(List<Mercadoria> mercadorias) {
		this.mercadorias = mercadorias;
	}
	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}
	public void setTempoPrevisto(String tempoPrevisto) {
		this.tempoPrevisto = tempoPrevisto;
	}
	public void setTempoReal(String tempoReal) {
		this.tempoReal = tempoReal;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Trajeto [id=" + id + ", veiculo=" + veiculo + ", mercadorias=" + mercadorias + ", dtInclusao="
				+ dtInclusao + ", tempoPrevisto=" + tempoPrevisto + ", tempoReal=" + tempoReal + ", status=" + status
				+ "]";
	}
	
}
