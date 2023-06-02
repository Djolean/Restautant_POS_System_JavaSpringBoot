package com.metropolitan.demo.service.impl;


import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.repository.JeloRepository;
import com.metropolitan.demo.repository.NarudzbinaRepository;
import com.metropolitan.demo.service.JeloService;
import com.metropolitan.demo.service.NarudzbinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NarudzbinaServiceImpl implements NarudzbinaService {
	private final NarudzbinaRepository narudzbinaRepository;
	private final JeloService jeloService;

	@Override
	public List<Narudzbina> findAll() {
		return narudzbinaRepository.findAll();
	}

	@Override
	public Narudzbina findById(Integer narudzbinaId) {
		return narudzbinaRepository.findById(narudzbinaId)
				.orElseThrow(() -> new NoSuchElementException("NarudzbinaService.notFound"));
	}

	@Override
	public Narudzbina save(Narudzbina narudzbina) {
		return narudzbinaRepository.save(narudzbina);
	}

	@Override
	public Narudzbina update(Narudzbina narudzbina) {
		return narudzbinaRepository.save(narudzbina);
	}

	@Override
	public void deleteById(Integer narudzbinaId) {
		narudzbinaRepository.deleteById(narudzbinaId);
	}

	@Override
	public void addToNarudzbina(Integer narudzbinaId, Integer jeloId) {
		Narudzbina narudzbina = findById(narudzbinaId);
		Jelo jelo = jeloService.findById(jeloId);
		narudzbina.setUkupnaCena(narudzbina.getUkupnaCena() + jelo.getCena());
		narudzbina.getJelos().add(jelo);
		narudzbinaRepository.save(narudzbina);
	}

	@Override
	public void deleteFromNarudzbina(Integer narudzbinaId, Integer jeloId) {
		Narudzbina narudzbina = findById(narudzbinaId);
		Jelo jelo = jeloService.findById(jeloId);
		narudzbina.setUkupnaCena(narudzbina.getUkupnaCena() - jelo.getCena());
		narudzbina.getJelos().remove(jelo);
		save(narudzbina);
	}


}