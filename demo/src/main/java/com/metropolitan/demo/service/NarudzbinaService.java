package com.metropolitan.demo.service;


import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.entity.Narudzbina;

import java.util.List;

public interface NarudzbinaService {

	List<Narudzbina> findAll();

	Narudzbina save(Narudzbina narudzbina);

	Narudzbina update(Narudzbina narudzbina);

	Narudzbina findById(Integer narudzbinaId);

	void deleteById(Integer narudzbinaId);

	void addToNarudzbina(Narudzbina narudzbina, Integer jeloId);

	void deleteFromNarudzbina(Integer narudzbinaId, Integer jeloId);

	double ukupnaCenaNarudzbine(List<Jelo> jela);
}