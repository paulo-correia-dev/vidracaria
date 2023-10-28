package com.sistemavidracaria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavidracaria.dto.request.KitDto;
import com.sistemavidracaria.model.Cor;
import com.sistemavidracaria.model.Ferragem;
import com.sistemavidracaria.model.FerragemKit;
import com.sistemavidracaria.model.Kit;
import com.sistemavidracaria.repository.FerragemKitRepository;
import com.sistemavidracaria.repository.FerragemRepository;
import com.sistemavidracaria.repository.KitRepository;

import jakarta.transaction.Transactional;

@Service
public class KitService{
	
	@Autowired
	private KitRepository kitRepository;
	
	@Autowired
	private FerragemKitRepository ferragemKitRepository;
	
	@Autowired
	private FerragemRepository ferragemRepository;

	@Transactional
	public void salvar(KitDto kitDto) {
		
		Kit kit = salvarKit(kitDto);
		
		if(kitDto.getFerragens() == null) {			
			kit.setCor(kitDto.getCor());			
			kit.setValor(kitDto.getValor());			
		}else {
			
			for(FerragemKit ferragemKit : kitDto.getFerragens()) {						
				ferragemKit.setKit(kit);
				ferragemKitRepository.save(ferragemKit);
			}
			
			double valorKit = 0.0;
			Cor cor = null;
			
			List<FerragemKit> ferragens = ferragemKitRepository.findByIdKit(kit.getId());
			
			for(FerragemKit ferragemKit : ferragens) {
				
				Optional<Ferragem> ferragem = ferragemRepository.findById(ferragemKit.getFerragem().getId());
				
				valorKit += ferragem.get().getValor();	
				cor = ferragem.get().getCor();
			}
			
			kit.setCor(cor);
			kit.setValor(valorKit);
		}
	}
	
	public Kit salvarKit(KitDto kitDto) {		
		Kit kit = new Kit();
		kit.setDescricao(kitDto.getDescricao());
		return kitRepository.save(kit);
	}

	public void excluir(int id) {
		kitRepository.deleteById(id);
	}

	public void atualizar(KitDto kitDto) {
		
		if(kitDto.getFerragens() == null) {			
			Kit kit = new Kit();
			kit.setId(kitDto.getId());
			kit.setCor(kitDto.getCor());
			kit.setDescricao(kitDto.getDescricao());
			kit.setValor(kitDto.getValor());
			
			kitRepository.save(kit);			
		}else {
			
			List<FerragemKit> banco = ferragemKitRepository.findByIdKit(kitDto.getId());
			List<FerragemKit> front = kitDto.getFerragens();
			
			for(FerragemKit ferragemKit : banco) {
				boolean achou = false;
				
				for(FerragemKit ferragemKit1 : front) {
					
					if(ferragemKit1.getId() == ferragemKit.getId()) {
						achou = true;
						
						ferragemKit.setId(ferragemKit1.getId());
						ferragemKit.setFerragem(ferragemKit1.getFerragem());
						ferragemKit.setKit(ferragemKit1.getKit());
						
						ferragemKitRepository.save(ferragemKit);						
					}					
				}
				
				if(achou == false) {
					ferragemKitRepository.delete(ferragemKit);
				}	
			}
			
			for(FerragemKit ferragemKit : front) {				
				boolean achou = false;
				
				for (FerragemKit ferragemKit1 : banco) {
					
					if(ferragemKit.getId() == ferragemKit1.getId()) {						
						achou = true;
					}
				}
				
				if(achou == false) {
					ferragemKitRepository.save(ferragemKit);
				}
			}
		}
	}

	public List<KitDto> listarTodos() {
		
		List<Kit> kits = kitRepository.findAll();
		
		List<KitDto> kitsDto = new ArrayList<>();
		
		for(Kit kit: kits) {
			KitDto kitDto = new KitDto();
			kitDto.setCor(kit.getCor());
			kitDto.setDescricao(kit.getDescricao());
			kitDto.setFerragens(kit.getFerragens());
			kitDto.setId(kit.getId());
			kitDto.setValor(kit.getValor());
			kitsDto.add(kitDto);
		}
		return kitsDto;
	}

}
