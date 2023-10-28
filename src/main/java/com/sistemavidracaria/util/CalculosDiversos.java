package com.sistemavidracaria.util;

public interface CalculosDiversos {
	public double calculaArea(double a, double b);
	public double calculaMaterialMetroQuadrado(double valorMetroQuadrado, double metragemQuadradaPeca);
	public double calculaValorTotalPeca(double valorKit, double valorVidroPeca, double valorPeliculaPeca);
	public double calculaValorFinalOrcamento(double valoresPecas, double margem);
}
