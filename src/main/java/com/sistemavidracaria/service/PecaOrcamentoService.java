package com.sistemavidracaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.model.PecaOrcamento;
import com.sistemavidracaria.repository.PecaOrcamentoRepository;

@Service
public class PecaOrcamentoService implements Crud<PecaOrcamento> {

	@Autowired
	private PecaOrcamentoRepository pecaOrcamentoRepository;
	
	@Override
	public void salvar(PecaOrcamento pecaOrcamento) {
		pecaOrcamentoRepository.save(pecaOrcamento);
	}

	@Override
	public void excluir(int id) {
		pecaOrcamentoRepository.deleteById(id);	
	}

	@Override
	public void atualizar(PecaOrcamento pecaOrcamento) {
		pecaOrcamentoRepository.save(pecaOrcamento);
	}

	@Override
	public List<PecaOrcamento> listarTodos() {
		return pecaOrcamentoRepository.findAll();
	}

}
