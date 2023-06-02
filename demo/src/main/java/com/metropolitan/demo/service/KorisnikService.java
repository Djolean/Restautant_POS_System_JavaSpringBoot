package com.metropolitan.demo.service;

import com.metropolitan.demo.entity.Korisnik;

import java.util.List;

public interface KorisnikService {

	List<Korisnik> findAll();

	Korisnik save(Korisnik korisnik);

	Korisnik update(Korisnik korisnik);

	Korisnik findById(Integer korisnikId);

	void deleteById(Integer korisnikId);
	Korisnik findByIme(String ime);
	Korisnik getLoggedInUser();

	boolean isUserAdmin();

}