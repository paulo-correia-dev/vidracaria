package com.sistemavidracaria.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Orcamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double margem;
	
	@Transient
	private List<PecaOrcamento> pecas;
	
	@Column(name = "valor_final")
	private double valorFinal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMargem() {
		return margem;
	}

	public void setMargem(double margem) {
		this.margem = margem;
	}

	/*public List<PecaOrcamento> getPecaOrcamento() {
		return pecaOrcamento;
	}

	public void setPecaOrcamento(List<PecaOrcamento> pecaOrcamento) {
		this.pecaOrcamento = pecaOrcamento;
	}*/

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

}
