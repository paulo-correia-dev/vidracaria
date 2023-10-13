package com.sistemavidracaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vidro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String espessura;
	
	@JoinColumn(name = "valor_metro_quadrado")
	private double valorMetroQuadrado;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn(name = "id_cor")
	private Cor cor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspessura() {
		return espessura;
	}

	public void setEspessura(String espessura) {
		this.espessura = espessura;
	}

	public double getValorMetroQuadrado() {
		return valorMetroQuadrado;
	}

	public void setValorMetroQuadrado(double valorMetroQuadrado) {
		this.valorMetroQuadrado = valorMetroQuadrado;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
}
