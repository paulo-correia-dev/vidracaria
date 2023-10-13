package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.Orcamento;
import com.sistemavidracaria.repository.OrcamentoRepository;

@Service
public class OrcamentoService implements Crud<Orcamento>{

	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@Override
	public void salvar(Orcamento orcamento) {
		orcamentoRepository.save(orcamento);
		
	}

	@Override
	public void excluir(int id) {
		orcamentoRepository.deleteById(id);
		
	}

	@Override
	public void atualizar(Orcamento orcamento) {
		orcamentoRepository.save(orcamento);
		
	}

	@Override
	public List<Orcamento> listarTodos() {
		return orcamentoRepository.findAll();
	}

}
