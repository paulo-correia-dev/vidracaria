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

import com.sistemavidracaria.model.FerragemKit;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.FerragemKitService;

@RestController
@RequestMapping("/ferragens-kits")
public class FerragemKitController implements Crud<FerragemKit>{
	
	@Autowired
	FerragemKitService ferragemKitService;

	@PostMapping
	@Override
	public void salvar(@RequestBody FerragemKit ferragem) {
		ferragemKitService.salvar(ferragem);
		
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		ferragemKitService.excluir(id);
		
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody FerragemKit ferragem) {
		ferragemKitService.atualizar(ferragem);
		
	}

	@GetMapping
	@Override
	public List<FerragemKit> listarTodos() {
		return ferragemKitService.listarTodos();
	}

}
