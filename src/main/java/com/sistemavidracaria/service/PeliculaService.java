package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Pelicula;
import com.sistemavidracaria.repository.PeliculaRepository;

@Service
public class PeliculaService implements Crud<Pelicula>{
	
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public void salvar(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
	}

	@Override
	public void excluir(int id) {
		peliculaRepository.deleteById(id);
	}

	@Override
	public void atualizar(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
	}

	@Override
	public List<Pelicula> listarTodos() {
		return peliculaRepository.findAll();
	}

}
