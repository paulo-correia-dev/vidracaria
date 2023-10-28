package com.sistemavidracaria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.dto.request.OrcamentoDto;
import com.sistemavidracaria.model.FerragemKit;
import com.sistemavidracaria.model.Orcamento;
import com.sistemavidracaria.model.Peca;
import com.sistemavidracaria.model.PecaOrcamento;
import com.sistemavidracaria.model.Pelicula;
import com.sistemavidracaria.model.Vidro;
import com.sistemavidracaria.repository.FerragemKitRepository;
import com.sistemavidracaria.repository.OrcamentoRepository;
import com.sistemavidracaria.repository.PecaOrcamentoRepository;
import com.sistemavidracaria.repository.PecaRepository;
import com.sistemavidracaria.repository.PeliculaRepository;
import com.sistemavidracaria.repository.VidroRepository;
import com.sistemavidracaria.util.CalculosDiversos;

import jakarta.transaction.Transactional;

@Service
public class OrcamentoService{

	@Autowired
	private CalculosDiversos calculosDiversos;
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@Autowired
	private PecaOrcamentoRepository pecaOrcamentoRepository;
	
	@Autowired
	private FerragemKitRepository ferragemKitRepository;
	
	@Autowired
	private VidroRepository vidroRepository;
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Autowired
	PecaRepository pecaRepository;
	
	@Transactional
	public void salvar(OrcamentoDto orcamentoDto) {
			
		Orcamento orcamento = salvarOrcamento(orcamentoDto);		
		
		double valoresPecas = 0.0;
		
		for(PecaOrcamento pecaOrcamento: orcamentoDto.getPecas()) {
			pecaOrcamento.setOrcamento(orcamento);		
		
			double metragemQuadradaPeca = calculosDiversos.calculaArea(pecaOrcamento.getAltura(), pecaOrcamento.getLargura());
			
			Optional<Vidro> vidro =  vidroRepository.findById(pecaOrcamento.getVidro().getId()); 
			
			Optional<Pelicula> pelicula = peliculaRepository.findById(pecaOrcamento.getPelicula().getId());	
			
			Optional<Peca> peca = pecaRepository.findById(pecaOrcamento.getPeca().getId()); 
		    
			valoresPecas += calculosDiversos.calculaValorTotalPeca(peca.get().getKit().getValor(),
																   calculosDiversos.calculaMaterialMetroQuadrado(vidro.get().getValorMetroQuadrado(), metragemQuadradaPeca),
																   calculosDiversos.calculaMaterialMetroQuadrado(pelicula.get().getValorMetroQuadrado(), metragemQuadradaPeca));
			
			pecaOrcamentoRepository.save(pecaOrcamento);	
			
		}
		
		orcamento.setValorFinal(calculosDiversos.calculaValorFinalOrcamento(valoresPecas, orcamento.getMargem()));
		
	}
	
	public Orcamento salvarOrcamento(OrcamentoDto orcamentoDto) {
		Orcamento orcamento = new Orcamento();
		orcamento.setMargem(orcamentoDto.getMargem());
		orcamento.setValorFinal(orcamentoDto.getValorFinal());
		
		return orcamentoRepository.save(orcamento);
	}

	public void excluir(int id) {
		orcamentoRepository.deleteById(id);
	}

	public void atualizar(OrcamentoDto orcamentoDto) {
		
		Orcamento orcamento = new Orcamento();
		orcamento.setId(orcamentoDto.getId());
		orcamento.setMargem(orcamentoDto.getMargem());
		
		List<PecaOrcamento> banco = pecaOrcamentoRepository.findByIdOrcamento(orcamento.getId());	
		
		List<PecaOrcamento> front = orcamentoDto.getPecas();
		
		//se o cara não inserir algo que já está no banco, ele vai no banco e apaga
		for(PecaOrcamento pecaOrcamento : banco) {			
			boolean encontrou = false;
			
			for(PecaOrcamento pecaOrcamento1 : front) {	
			
				if(pecaOrcamento.getId() == pecaOrcamento1.getId()) {
					encontrou = true;
					
					pecaOrcamento.setAltura(pecaOrcamento1.getAltura());
					pecaOrcamento.setLargura(pecaOrcamento1.getLargura());
					pecaOrcamento.setPelicula(pecaOrcamento1.getPelicula());
					pecaOrcamento.setVidro(pecaOrcamento1.getVidro());
					
					pecaOrcamentoRepository.save(pecaOrcamento);
				}
			}
			
			if(encontrou == false) {				
				pecaOrcamentoRepository.deleteById(pecaOrcamento.getId());
			}	
		}
		
		//se o cara inserir algo que não tem no banco, ele vai no banco e insere
		for(PecaOrcamento pecaOrcamento: front) {
			boolean encontrou = false;
			
			for(PecaOrcamento pecaOrcamento1: banco) {
				if(pecaOrcamento.getId() == pecaOrcamento1.getId()) {
					encontrou = true;
				}
			}
			
			if(encontrou == false) {
				pecaOrcamentoRepository.save(pecaOrcamento);
			}
		}
		
		double valoresPecas = 0.0;
		
		banco = pecaOrcamentoRepository.findByIdOrcamento(orcamento.getId());
		
		for(PecaOrcamento pecaOrcamento : banco) {	
			
			double metragemQuadradaPeca = calculosDiversos.calculaArea(pecaOrcamento.getAltura(), pecaOrcamento.getLargura());
			
			Optional<Vidro> vidro = vidroRepository.findById(pecaOrcamento.getVidro().getId());
			
			double valorVidro = vidro.get().getValorMetroQuadrado() * metragemQuadradaPeca;
			
			Optional<Pelicula> pelicula = peliculaRepository.findById(pecaOrcamento.getPelicula().getId());
			
			double valorPelicula = pelicula.get().getValorMetroQuadrado() * metragemQuadradaPeca;			
			
			List<FerragemKit> kit = ferragemKitRepository.findByIdKit(pecaOrcamento.getPeca().getKit().getId());
			
			double valorKit = 0.0;
			
			for (FerragemKit ferragemKit : kit) {				
				valorKit += ferragemKit.getFerragem().getValor();
			}
			
			double valorPeca = valorVidro + valorPelicula + valorKit;
			
			valoresPecas += valorPeca;
			
		}
		
		orcamento.setValorFinal(valoresPecas + valoresPecas * orcamento.getMargem());
		
		orcamentoRepository.save(orcamento);		
		
	}

	public List<OrcamentoDto> listarTodos() {
		
		List<Orcamento> orcamentos = orcamentoRepository.findAll();
		
		List<OrcamentoDto> orcamentosDto = new ArrayList<>();
		
		for(Orcamento orcamento: orcamentos) {
			
			OrcamentoDto orcamentoDto = new OrcamentoDto();
			orcamentoDto.setId(orcamento.getId());
			orcamentoDto.setMargem(orcamento.getMargem());
			orcamentoDto.setValorFinal(orcamento.getValorFinal());
			
			List<PecaOrcamento> pecas = pecaOrcamentoRepository.findByIdOrcamento(orcamento.getId());
			
			orcamentoDto.setPecas(pecas);
			
			orcamentosDto.add(orcamentoDto);
			
		}
		
		
		
		return orcamentosDto;
	}

}
