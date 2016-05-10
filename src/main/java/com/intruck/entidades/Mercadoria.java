package com.intruck.entidades;

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
	
	
	public Mercadoria(){
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (telefoneReceb == null) {
			if (other.telefoneReceb != null)
				return false;
		} else if (!telefoneReceb.equals(other.telefoneReceb))
			return false;
		return true;
	}

	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public double getPeso() {
		return peso;
	}
	public int getFragilidade() {
		return fragilidade;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public String getCep() {
		return cep;
	}
	public String getPais() {
		return pais;
	}
	public String getEstado() {
		return estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public String getNomeReceb() {
		return nomeReceb;
	}
	public String getTelefoneReceb() {
		return telefoneReceb;
	}
	public byte getAtivo() {
		return ativo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setFragilidade(int fragilidade) {
		this.fragilidade = fragilidade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setNomeReceb(String nomeReceb) {
		this.nomeReceb = nomeReceb;
	}
	public void setTelefoneReceb(String telefoneReceb) {
		this.telefoneReceb = telefoneReceb;
	}
	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "Mercadoria [id=" + id + ", descricao=" + descricao + ", peso=" + peso + ", fragilidade=" + fragilidade
				+ ", prioridade=" + prioridade + ", cep=" + cep + ", pais=" + pais + ", estado=" + estado
				+ ", municipio=" + municipio + ", logradouro=" + logradouro + ", numero=" + numero + ", nomeReceb="
				+ nomeReceb + ", telefoneReceb=" + telefoneReceb + ", ativo=" + ativo + "]";
	}
	
	

}
