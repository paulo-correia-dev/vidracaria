package com.sistemavidracaria.dto.request;

import java.util.List;

import com.sistemavidracaria.model.Cor;
import com.sistemavidracaria.model.FerragemKit;

public class KitDto {
	
	private int id;
	
	private String descricao;
	
	private double valor;
	
	private List<FerragemKit> ferragens;
	
	private Cor cor;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<FerragemKit> getFerragens() {
		return ferragens;
	}

	public void setFerragens(List<FerragemKit> ferragens) {
		this.ferragens = ferragens;
	}

}
