package com.sistemavidracaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FerragemKit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_ferragem")
	private Ferragem ferragem;
	
	@ManyToOne
	@JoinColumn(name = "id_kit")
	private Kit kit;

	public Ferragem getFerragem() {
		return ferragem;
	}

	public void setFerragem(Ferragem ferragem) {
		this.ferragem = ferragem;
	}

	public Kit getKit() {
		return kit;
	}

	public void setKit(Kit kit) {
		this.kit = kit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
