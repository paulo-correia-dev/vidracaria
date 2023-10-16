package com.sistemavidracaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemavidracaria.model.FerragemKit;

public interface FerragemKitRepository extends JpaRepository<FerragemKit, Integer>{
		
	@Query("select a from FerragemKit a where a.kit.id = :idKit")
	List<FerragemKit> findByIdKit(@Param("idKit") Integer idKit);	

}
