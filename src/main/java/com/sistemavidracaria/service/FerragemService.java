package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Ferragem;
import com.sistemavidracaria.repository.FerragemRepository;

@Service
public class FerragemService implements Crud<Ferragem>{

	@Autowired
	private FerragemRepository ferragemRepository;
	
	@Override
	public void salvar(Ferragem ferragem) {
		ferragemRepository.save(ferragem);	
	}

	@Override
	public void excluir(int id) {
		ferragemRepository.deleteById(id);
	}

	@Override
	public void atualizar(Ferragem ferragem) {
		ferragemRepository.save(ferragem);
	}

	@Override
	public List<Ferragem> listarTodos() {
		return ferragemRepository.findAll();
	}

}
