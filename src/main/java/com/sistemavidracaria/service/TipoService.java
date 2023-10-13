package com.sistemavidracaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Tipo;
import com.sistemavidracaria.repository.TipoRepository;

@Service
public class TipoService implements Crud<Tipo>{

	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	public void salvar(Tipo tipo) {
		tipoRepository.save(tipo);
	}

	@Override
	public void excluir(int id) {
		tipoRepository.deleteById(id);
	}

	@Override
	public void atualizar(Tipo tipo) {
		tipoRepository.save(tipo);
	}

	@Override
	public List<Tipo> listarTodos() {
		return tipoRepository.findAll();
	}
	
	public Optional<Tipo> buscarPorId(int id) {
		return tipoRepository.findById(id);
	}
	
}
