package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Usuario;
import com.sistemavidracaria.repository.UsuarioRepository;

@Service
public class UsuarioService implements Crud<Usuario>{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void excluir(int id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public void atualizar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> listarTodos() {		
		return usuarioRepository.findAll();
	}

}
