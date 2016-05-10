package com.intruck.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String placa;
	private String marca;
	private String modelo;
	private int ano;
	private String cor;
	private double altura;
	private double largura;
	private double comprimento;
	private double capacidade;
	private byte ativo;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	public Veiculo(){
	
	}
	
	public Veiculo(Long id, String placa, String marca, String modelo, int ano, String cor, double altura,
			double largura, double comprimento, double capacidade, byte ativo) {
		super();
		this.id = id;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
		this.capacidade = capacidade;
		this.ativo = ativo;
	}
	
	public Long getId() {
		return id;
	}
	public String getPlaca() {
		return placa;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getAno() {
		return ano;
	}
	public String getCor() {
		return cor;
	}
	public double getAltura() {
		return altura;
	}
	public double getLargura() {
		return largura;
	}
	public double getComprimento() {
		return comprimento;
	}
	public double getCapacidade() {
		return capacidade;
	}
	public byte getAtivo() {
		return ativo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}
	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano
				+ ", cor=" + cor + ", altura=" + altura + ", largura=" + largura + ", comprimento=" + comprimento
				+ ", capacidade=" + capacidade + ", ativo=" + ativo + "]";
	}
	
	
	
	
}
