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

import com.sistemavidracaria.model.Cor;
import com.sistemavidracaria.service.CorService;
import com.sistemavidracaria.service.Crud;

@RestController
@RequestMapping("/cores")
public class CorController implements Crud<Cor> {

	@Autowired
	private CorService corService;
	
	@PostMapping
	@Override
	public void salvar(@RequestBody Cor cor) {
		corService.salvar(cor);		
	}

	@DeleteMapping("/{id}")
	@Override
	public void excluir(@PathVariable int id) {
		corService.excluir(id);		
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody Cor cor) {
		corService.atualizar(cor);		
	}

	@GetMapping
	@Override
	public List<Cor> listarTodos() {
		return corService.listarTodos();
	}

}
