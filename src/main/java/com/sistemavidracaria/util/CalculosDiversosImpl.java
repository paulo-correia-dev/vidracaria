package com.sistemavidracaria.util;

import org.springframework.stereotype.Component;

@Component
public class CalculosDiversosImpl implements CalculosDiversos{
	
	@Override
	public double calculaArea(double a, double b) {		
		return (a/100) * (b/100) ;
	}	

	@Override
	public double calculaMaterialMetroQuadrado(double valorMetroQuadrado, double metragemQuadradaPeca) {
		return valorMetroQuadrado * metragemQuadradaPeca;
	}
	
	@Override
	public double calculaValorTotalPeca(double valorKit, double valorVidroPeca, double valorPeliculaPeca) {		
		return valorKit + valorVidroPeca + valorPeliculaPeca;
	}

	@Override
	public double calculaValorFinalOrcamento(double valoresPecas, double margem) {		
		return valoresPecas + valoresPecas * margem;
	}
	
}
