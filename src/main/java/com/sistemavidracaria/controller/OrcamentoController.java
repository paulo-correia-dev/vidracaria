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

import com.sistemavidracaria.dto.request.OrcamentoDto;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.OrcamentoService;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController implements Crud<OrcamentoDto>{

	@Autowired
	OrcamentoService orcamentoService;
	
	@PostMapping
	@Override
	public void salvar(@RequestBody OrcamentoDto orcamentoDto) {
		orcamentoService.salvar(orcamentoDto);
		
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		orcamentoService.excluir(id);
		
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody OrcamentoDto orcamentoDto) {
		orcamentoService.atualizar(orcamentoDto);
		
	}

	@GetMapping
	@Override
	public List<OrcamentoDto> listarTodos() {
		return orcamentoService.listarTodos();
		
	}

}
