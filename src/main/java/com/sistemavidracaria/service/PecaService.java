package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Peca;
import com.sistemavidracaria.repository.PecaRepository;

@Service
public class PecaService implements Crud<Peca>{
	
	@Autowired
	private PecaRepository pecaRepository;

	@Override
	public void salvar(Peca peca) {
		pecaRepository.save(peca);
	}

	@Override
	public void excluir(int id) {
		pecaRepository.deleteById(id);
	}

	@Override
	public void atualizar(Peca peca) {
		pecaRepository.save(peca);
	}

	@Override
	public List<Peca> listarTodos() {
		return pecaRepository.findAll();
	}

}
