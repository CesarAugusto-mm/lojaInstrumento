package com.loja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "td_instrumento")
public class Instrumentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@NotBlank(message = "O valor não pode ser branco ou nulo")
	private String nome;
	
	@NotBlank(message = "O valor não pode ser branco ou nulo")
	private String tipo;
	
	@NotBlank(message = "O valor não pode ser branco ou nulo")
	private String cor;
	
	@Min(value = 1, message = "O numero não pode ser menor que 1")
	private Integer quantidadedepeças;
	
	private boolean elétrico;
	
	public Instrumentos() {
		super();		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public Integer getQuantidadedepeças() {
		return quantidadedepeças;
	}
	public void setQuantidadedepeças(Integer quantidadedepeças) {
		this.quantidadedepeças = quantidadedepeças;
	}
	
	public boolean isElétrico() {
		return elétrico;
	}
	
	public void setElétrico(boolean elétrico) {
		this.elétrico = elétrico;
	}
	
	public Instrumentos(String nome, String tipo, String cor, Integer quantidadedepeças, boolean elétrico) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.cor = cor;
		this.quantidadedepeças = quantidadedepeças;
		this.elétrico = elétrico;
	}		

}
