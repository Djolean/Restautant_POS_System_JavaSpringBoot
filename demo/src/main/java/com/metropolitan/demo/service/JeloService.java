package com.metropolitan.demo.service;

import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.entity.*;

import java.util.List;

public interface JeloService{

	List<Jelo> findAll();

	Jelo save(Jelo jelo);

	Jelo update(Jelo jelo);

	Jelo findById(Integer jeloId);

	void deleteById(Integer jeloId);

	List<Jelo> sortJeloByPriceDesc(List<Jelo> jelos);

	List<Jelo> sortJeloByPriceAsc(List<Jelo> jelos);

	List<Jelo> sortJeloByNameAsc(List<Jelo> jelos);
	List<Jelo> sortJeloByNameDesc(List<Jelo> jelos);
}