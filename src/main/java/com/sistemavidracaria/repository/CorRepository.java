package com.sistemavidracaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemavidracaria.model.Cor;

public interface CorRepository extends JpaRepository<Cor, Integer> {
	
	Optional<Cor> findByDescricao (String descricao);

}
