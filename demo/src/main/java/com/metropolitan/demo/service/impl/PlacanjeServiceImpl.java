package com.metropolitan.demo.service.impl;


import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.entity.Placanje;
import com.metropolitan.demo.repository.PlacanjeRepository;
import com.metropolitan.demo.service.PlacanjeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlacanjeServiceImpl implements PlacanjeService {
	private final PlacanjeRepository placanjeRepository;

	@Override
	public List<Placanje> findAll() {
		return placanjeRepository.findAll();
	}

	@Override
	public Placanje findById(Integer placanjeId) {
		return placanjeRepository.findById(placanjeId)
				.orElseThrow(() -> new NoSuchElementException("PlacanjeService.notFound"));
	}

	@Override
	public Placanje save(Placanje placanje) {
		return placanjeRepository.save(placanje);
	}

	@Override
	public Placanje update(Placanje placanje) {
		return placanjeRepository.save(placanje);
	}

	@Override
	public void deleteById(Integer placanjeId) {
		placanjeRepository.deleteById(placanjeId);
	}

	@Override
	public void naplati(Narudzbina narudzbina) {
		Placanje placanje = new Placanje();
		UUID barcode = UUID.randomUUID();
		placanje.setBarCode(barcode);
		placanje.setDatumPlacanja(LocalDateTime.now());
		placanje.setNarudzbinaId(narudzbina);
		save(placanje);
	}
}