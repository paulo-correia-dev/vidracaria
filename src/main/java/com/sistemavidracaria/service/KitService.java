package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Kit;
import com.sistemavidracaria.repository.KitRepository;

@Service
public class KitService implements Crud<Kit> {
	
	@Autowired
	private KitRepository kitRepository;

	@Override
	public void salvar(Kit kit) {
		kitRepository.save(kit);
	}

	@Override
	public void excluir(int id) {
		kitRepository.deleteById(id);
	}

	@Override
	public void atualizar(Kit kit) {
		kitRepository.save(kit);
	}

	@Override
	public List<Kit> listarTodos() {
		return kitRepository.findAll();
	}

}
