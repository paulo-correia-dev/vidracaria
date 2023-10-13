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

import com.sistemavidracaria.model.PecaOrcamento;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.PecaOrcamentoService;

@RestController
@RequestMapping("pecas-orcamentos")
public class PecaOrcamentoController implements Crud<PecaOrcamento>{
	
	@Autowired
	private PecaOrcamentoService pecaOrcamentoService;

	@PostMapping
	@Override
	public void salvar(@RequestBody PecaOrcamento pecaOrcamento) {
		pecaOrcamentoService.salvar(pecaOrcamento);	
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		pecaOrcamentoService.excluir(id);
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody PecaOrcamento pecaOrcamento) {
		pecaOrcamentoService.atualizar(pecaOrcamento);
	}

	@GetMapping
	@Override
	public List<PecaOrcamento> listarTodos() {
		return pecaOrcamentoService.listarTodos();
	}

}
