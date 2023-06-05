package com.metropolitan.demo.service;

import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.entity.Placanje;

import java.util.List;

public interface PlacanjeService {

	List<Placanje> findAll();

	Placanje save(Placanje placanje);

	Placanje update(Placanje placanje);

	Placanje findById(Integer placanjeId);

	void deleteById(Integer placanjeId);

	void naplati(Integer narudzbinaId);
}