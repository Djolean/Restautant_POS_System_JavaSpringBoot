package com.metropolitan.demo.service.impl;


import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.repository.JeloRepository;
import com.metropolitan.demo.repository.NarudzbinaRepository;
import com.metropolitan.demo.service.JeloService;
import com.metropolitan.demo.service.KorisnikService;
import com.metropolitan.demo.service.NarudzbinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NarudzbinaServiceImpl implements NarudzbinaService {
	private final NarudzbinaRepository narudzbinaRepository;
	private final JeloService jeloService;
	private final KorisnikService korisnikService;

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
	public void addToNarudzbina(Narudzbina narudzbina, Integer jeloId) {
		Jelo jelo = jeloService.findById(jeloId);
		List<Jelo> jela = new ArrayList<>();
		jela.add(jelo);
		narudzbina.setJelos(jela);
		narudzbina.setDatum(LocalDate.from(LocalDateTime.now()));
		narudzbina.setKorisnikId(korisnikService.getLoggedInUser());
		narudzbina.setUkupnaCena(ukupnaCenaNarudzbine(jela));

		save(narudzbina);
	}

	@Override
	public void deleteFromNarudzbina(Integer narudzbinaId, Integer jeloId) {
		Narudzbina narudzbina = findById(narudzbinaId);
		Jelo jelo = jeloService.findById(jeloId);
		narudzbina.setUkupnaCena(narudzbina.getUkupnaCena() - jelo.getCena());
		narudzbina.getJelos().remove(jelo);
		save(narudzbina);
	}

	@Override
	public double ukupnaCenaNarudzbine(List<Jelo> jela) {
		double ukupnaCena = 0.0;
		for (Jelo j : jela){
			ukupnaCena += j.getCena();
		}
		return ukupnaCena;
	}


}