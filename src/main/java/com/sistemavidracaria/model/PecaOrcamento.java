package com.sistemavidracaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PecaOrcamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double largura;	
	private double altura; 
	
	@ManyToOne
	@JoinColumn(name = "id_vidro")
	private Vidro vidro;
	
	@ManyToOne
	@JoinColumn(name = "id_pelicula")
	private Pelicula pelicula;

	@ManyToOne
	@JoinColumn(name = "id_orcamento")
	private Orcamento orcamento;
	
	@ManyToOne
	@JoinColumn(name = "id_peca")
	private Peca peca;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	public Vidro getVidro() {
		return vidro;
	}
	public void setVidro(Vidro vidro) {
		this.vidro = vidro;
	}

}
