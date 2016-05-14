package com.logistica.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mercadoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String descricao;
	private double peso;
	private int fragilidade;
	private int prioridade;
	private String cep;
	private String pais;
	private String estado;
	private String municipio;
	private String logradouro;
	private String numero;
	private String nomeReceb;
	private String telefoneReceb;
	private byte ativo;

	public Mercadoria() {
		super();
	}

	public Mercadoria(Long id, String descricao, double peso, int fragilidade, int prioridade, String cep, String pais,
			String estado, String municipio, String logradouro, String numero, String nomeReceb, String telefoneReceb,
			byte ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.peso = peso;
		this.fragilidade = fragilidade;
		this.prioridade = prioridade;
		this.cep = cep;
		this.pais = pais;
		this.estado = estado;
		this.municipio = municipio;
		this.logradouro = logradouro;
		this.numero = numero;
		this.nomeReceb = nomeReceb;
		this.telefoneReceb = telefoneReceb;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getFragilidade() {
		return fragilidade;
	}

	public void setFragilidade(int fragilidade) {
		this.fragilidade = fragilidade;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNomeReceb() {
		return nomeReceb;
	}

	public void setNomeReceb(String nomeReceb) {
		this.nomeReceb = nomeReceb;
	}

	public String getTelefoneReceb() {
		return telefoneReceb;
	}

	public void setTelefoneReceb(String telefoneReceb) {
		this.telefoneReceb = telefoneReceb;
	}

	public byte getAtivo() {
		return ativo;
	}

	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ativo;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + fragilidade;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((nomeReceb == null) ? 0 : nomeReceb.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + prioridade;
		result = prime * result + ((telefoneReceb == null) ? 0 : telefoneReceb.hashCode());
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
		Mercadoria other = (Mercadoria) obj;
		if (ativo != other.ativo)
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fragilidade != other.fragilidade)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (nomeReceb == null) {
			if (other.nomeReceb != null)
				return false;
		} else if (!nomeReceb.equals(other.nomeReceb))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (prioridade != other.prioridade)
			return false;
		if (telefoneReceb == null) {
			if (other.telefoneReceb != null)
				return false;
		} else if (!telefoneReceb.equals(other.telefoneReceb))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mercadoria [id=" + id + ", descricao=" + descricao + ", peso=" + peso + ", fragilidade=" + fragilidade
				+ ", prioridade=" + prioridade + ", cep=" + cep + ", pais=" + pais + ", estado=" + estado
				+ ", municipio=" + municipio + ", logradouro=" + logradouro + ", numero=" + numero + ", nomeReceb="
				+ nomeReceb + ", telefoneReceb=" + telefoneReceb + ", ativo=" + ativo + "]";
	}

}
