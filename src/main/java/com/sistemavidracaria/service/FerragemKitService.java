package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.FerragemKit;
import com.sistemavidracaria.repository.FerragemKitRepository;

@Service
public class FerragemKitService implements Crud<FerragemKit>{

	@Autowired
	FerragemKitRepository ferragemKitRepository;
	
	@Override
	public void salvar(FerragemKit ferragemKit) {
		ferragemKitRepository.save(ferragemKit);
		
	}

	@Override
	public void excluir(int id) {
		ferragemKitRepository.deleteById(id);
		
	}

	@Override
	public void atualizar(FerragemKit ferragemKit) {
		ferragemKitRepository.save(ferragemKit);
		
	}

	@Override
	public List<FerragemKit> listarTodos() {		
		return ferragemKitRepository.findAll();
	}

}
