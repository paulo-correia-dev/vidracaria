package com.sistemavidracaria.dto.request;

import java.util.List;

import com.sistemavidracaria.model.PecaOrcamento;

public class OrcamentoDto {
	
	private int id;
	
	private double margem;
	
	private List<PecaOrcamento> pecas;
	
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

	public List<PecaOrcamento> getPecas() {
		return pecas;
	}

	public void setPecas(List<PecaOrcamento> pecas) {
		this.pecas = pecas;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

}
