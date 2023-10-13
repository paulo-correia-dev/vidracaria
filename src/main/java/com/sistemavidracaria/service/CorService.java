package com.sistemavidracaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Cor;
import com.sistemavidracaria.repository.CorRepository;

@Service
public class CorService implements Crud<Cor>{
	
	@Autowired
	private CorRepository corRepository;

	@Override
	public void salvar(Cor cor) {		
		corRepository.save(cor);		
	}

	@Override
	public void excluir(int id) {
		corRepository.deleteById(id);		
	}

	@Override
	public void atualizar(Cor cor) {
		corRepository.save(cor);		
	}

	@Override
	public List<Cor> listarTodos() {		
		return corRepository.findAll();
	}
	
	public Optional<Cor> buscarPorId(int id) {
		
		return corRepository.findById(id);
	}
	
}
