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

import com.sistemavidracaria.model.Vidro;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.VidroService;

@RestController
@RequestMapping("/vidros")
public class VidroController implements Crud<Vidro>{

	@Autowired
	private VidroService vidroService;
	
	@PostMapping
	@Override
	public void salvar(@RequestBody Vidro vidro) {
		vidroService.salvar(vidro);
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) { 
		vidroService.excluir(id);
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody Vidro vidro) {
		vidroService.atualizar(vidro);
	}

	@GetMapping
	@Override
	public List<Vidro> listarTodos() {
		return vidroService.listarTodos();
	}

}
