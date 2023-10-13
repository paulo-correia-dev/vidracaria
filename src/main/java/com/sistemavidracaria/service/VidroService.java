package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Vidro;
import com.sistemavidracaria.repository.VidroRepository;

@Service
public class VidroService implements Crud<Vidro>{

	@Autowired
	private VidroRepository vidroRepository;
	
	@Override
	public void salvar(Vidro vidro) {
		vidroRepository.save(vidro);
	}

	@Override
	public void excluir(int id) {
		vidroRepository.deleteById(id);
	}

	@Override
	public void atualizar(Vidro vidro) {
		vidroRepository.save(vidro);
	}

	@Override
	public List<Vidro> listarTodos() {
		return vidroRepository.findAll();
	}

}
