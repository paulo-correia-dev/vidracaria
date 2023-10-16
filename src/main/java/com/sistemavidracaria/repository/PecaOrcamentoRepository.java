package com.sistemavidracaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemavidracaria.model.PecaOrcamento;

public interface PecaOrcamentoRepository extends JpaRepository<PecaOrcamento, Integer> {
	
	@Query("select a from PecaOrcamento a where a.orcamento.id = :idOrcamento")
	List<PecaOrcamento> findByIdOrcamento(@Param("idOrcamento") Integer idOrcamento);	

}
