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

import com.sistemavidracaria.model.Tipo;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.TipoService;

@RestController
@RequestMapping("/tipos")
public class TipoController implements Crud<Tipo>{
	
	@Autowired
	private TipoService tipoService;

	@PostMapping
	@Override
	public void salvar(@RequestBody Tipo tipo) {
		tipoService.salvar(tipo);
		
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		tipoService.excluir(id);
		
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody Tipo tipo) {
		tipoService.atualizar(tipo);
		
	}

	@GetMapping
	@Override
	public List<Tipo> listarTodos() {
		return tipoService.listarTodos();
	}

}
