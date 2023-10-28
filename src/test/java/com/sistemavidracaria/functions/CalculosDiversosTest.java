package com.sistemavidracaria.functions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sistemavidracaria.util.CalculosDiversos;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CalculosDiversosTest {
	
	@Autowired
	CalculosDiversos calculosDiversos;
	
	@Test
	void calculoArea() {		
		double resultado = calculosDiversos.calculaArea(200, 200);
		assertEquals(resultado, 4);		
	}
	
	@Test
	 void calculaMaterialMetroQuadrado() {
		assertEquals(calculosDiversos.calculaMaterialMetroQuadrado(50, 2), 100);
	}

	@Test
	void calculaValorTotalPeca() {
		assertEquals(calculosDiversos.calculaValorTotalPeca(280, 220, 50), 550);
	}
	
	@Test
	void calculaValorFinalOrcamento(){
		assertEquals(calculosDiversos.calculaValorFinalOrcamento(500, 0.5), 750);
	}
	
	
}
