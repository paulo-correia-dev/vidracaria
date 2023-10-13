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

import com.sistemavidracaria.model.Ferragem;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.FerragemService;

@RestController
@RequestMapping("/ferragens")
public class FerragemController implements Crud<Ferragem> {

	@Autowired
	private FerragemService ferragemService;
	
	@PostMapping
	@Override
	public void salvar(@RequestBody Ferragem ferragem) {
		ferragemService.salvar(ferragem);
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		ferragemService.excluir(id);
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody Ferragem ferragem) {
		ferragemService.atualizar(ferragem);
	}

	@GetMapping
	@Override
	public List<Ferragem> listarTodos() {
		return ferragemService.listarTodos();
	}

	
}
