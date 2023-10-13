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

import com.sistemavidracaria.model.Usuario;
import com.sistemavidracaria.service.Crud;
import com.sistemavidracaria.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements Crud<Usuario> {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	@Override
	public void salvar(@RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
	}

	@DeleteMapping("{id}")
	@Override
	public void excluir(@PathVariable int id) {
		usuarioService.excluir(id);
	}

	@PutMapping
	@Override
	public void atualizar(@RequestBody Usuario usuario) {
		usuarioService.atualizar(usuario);
	}

	@GetMapping
	@Override
	public List<Usuario> listarTodos() {
		return usuarioService.listarTodos();
	}

}
