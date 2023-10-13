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

import com.sistemavidracaria.model.Orcamento;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.OrcamentoService;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController implements Crud<Orcamento>{

	@Autowired
	OrcamentoService orcamentoService;
	
	@PostMapping
	@Override
	public void salvar(@RequestBody Orcamento orcamento) {
		orcamentoService.salvar(orcamento);
		
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		orcamentoService.excluir(id);
		
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody Orcamento orcamento) {
		orcamentoService.atualizar(orcamento);
		
	}

	@GetMapping
	@Override
	public List<Orcamento> listarTodos() {
		return orcamentoService.listarTodos();
	}

}
