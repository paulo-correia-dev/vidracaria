package com.sistemavidracaria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sistemavidracaria.model.Cor;
import com.sistemavidracaria.repository.CorRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CorServiceTest {
	
	@Autowired
	Crud<Cor> corService;
	
	@Autowired 
	CorRepository corRepository;

	@Test
	void salvarCor() {
		Cor cor = new Cor();
		cor.setDescricao("Natural Fosco");		
		corService.salvar(cor);
		
		Optional<Cor> cor1 = corRepository.findByDescricao(cor.getDescricao());
		assertTrue(cor1.isPresent());
	
		corRepository.delete(cor);
	}
	
	@Test
	void atualizarCor() {		
		Cor cor = new Cor();
		cor.setDescricao("Natural Fosco");		
		corService.salvar(cor);		
		cor.setDescricao("Preto");		
		corService.salvar(cor);
		Optional<Cor> corBd = corRepository.findById(cor.getId());
		
		assertTrue(corBd.get().getDescricao() == "Preto");
		
		corRepository.delete(cor);
	}
	
	@Test
	void excluirCor() {		
		Cor cor = new Cor();
		cor.setDescricao("Natural Fosco");		
		corService.salvar(cor);
		
		corService.excluir(cor.getId());
		
		Optional<Cor> corBanco = corRepository.findById(cor.getId());
		
		assertFalse(corBanco.isPresent());		
	}
	
	@Test
	void listarTodasCores() {
		
		Cor cor1 = new Cor();
		cor1.setDescricao("Verde");		
		corService.salvar(cor1);
		
		Cor cor2 = new Cor();
		cor2.setDescricao("Azul");		
		corService.salvar(cor2);
		
		Cor cor3 = new Cor();
		cor3.setDescricao("Amarelo");		
		corService.salvar(cor3);
		
		List<Cor> cores = corRepository.findAll();
		
		assertEquals(cores.size(), 3);
	}
	
}
