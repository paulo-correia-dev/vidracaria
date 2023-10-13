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

import com.sistemavidracaria.model.Peca;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.PecaService;

@RestController
@RequestMapping("/pecas")
public class PecaController implements Crud<Peca>{
	
	@Autowired
	private PecaService pecaService;  
	
	@PostMapping
	@Override
	public void salvar(@RequestBody Peca peca) {
		pecaService.salvar(peca);		
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		pecaService.excluir(id);		
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody Peca peca) {
		pecaService.salvar(peca);		
	}

	@GetMapping
	@Override
	public List<Peca> listarTodos() {
		return pecaService.listarTodos();
	}

}
