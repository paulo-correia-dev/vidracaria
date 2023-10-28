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

import com.sistemavidracaria.dto.request.KitDto;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.KitService;

@RestController
@RequestMapping("/kits")
public class KitController implements Crud<KitDto>{
	
	@Autowired
	private KitService kitService;

	@PostMapping
	@Override
	public void salvar(@RequestBody KitDto kitDto) {
		kitService.salvar(kitDto);
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		kitService.excluir(id);	
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody KitDto kitDto) {
		kitService.atualizar(kitDto);
	}

	@GetMapping
	@Override
	public List<KitDto> listarTodos() {
		return kitService.listarTodos();
		
	}

}
