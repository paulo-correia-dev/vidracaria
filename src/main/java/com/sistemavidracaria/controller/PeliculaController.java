package com.sistemavidracaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemavidracaria.model.Pelicula;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.PeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController implements Crud<Pelicula>{

	@Autowired
	private PeliculaService peliculaService;

	@PostMapping
	@Override
	public void salvar(@RequestBody Pelicula pelicula) {
	
		peliculaService.salvar(pelicula);
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		peliculaService.excluir(id);	
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody Pelicula pelicula) {
		peliculaService.atualizar(pelicula);
	}

	@GetMapping
	@Override
	public List<Pelicula> listarTodos() {
		return peliculaService.listarTodos();
	}
	

}
