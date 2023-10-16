package com.sistemavidracaria.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.sistemavidracaria.repository.FerragemKitRepository;
import com.sistemavidracaria.repository.PecaOrcamentoRepository;
import com.sistemavidracaria.repository.PeliculaRepository;
import com.sistemavidracaria.repository.VidroRepository;

public class CalculosDiversos {
	
	@Autowired
	static
	PecaOrcamentoRepository pecaOrcamentoRepository;
	
	@Autowired
	static
	VidroRepository vidroRepository;
	
	@Autowired
	static
	PeliculaRepository peliculaRepository;
	
	@Autowired
	static
	FerragemKitRepository ferragemKitRepository;
	
	public static double calculaArea(double a, double b) {		
		return (a/100) * (b/100) ;
	}	

}
