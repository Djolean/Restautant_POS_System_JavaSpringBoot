package com.metropolitan.demo.service.impl;


import com.metropolitan.demo.entity.Korisnik;
import com.metropolitan.demo.entity.Role;
import com.metropolitan.demo.repository.KorisnikRepository;
import com.metropolitan.demo.security.SecurityUtil;
import com.metropolitan.demo.service.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class KorisnikServiceImpl implements KorisnikService {
	private final KorisnikRepository korisnikRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}

	@Override
	public Korisnik findById(Integer korisnikId) {
		return korisnikRepository.findById(korisnikId)
				.orElseThrow(() -> new NoSuchElementException("KorisnikService.notFound"));
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		korisnik.setLozinka(passwordEncoder.encode(korisnik.getLozinka()));
		return korisnikRepository.save(korisnik);
	}

	@Override
	public Korisnik update(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	@Override
	public void deleteById(Integer korisnikId) {
		korisnikRepository.deleteById(korisnikId);
	}

	@Override
	public Korisnik findByIme(String ime) {
		return korisnikRepository.findByIme(ime);
	}

	@Override
	public Korisnik getLoggedInUser() {
		String ime = SecurityUtil.getSessionUser();
		return findByIme(ime);
	}

	@Override
	public boolean isUserAdmin() {
		return getLoggedInUser() != null && getLoggedInUser().getRoleId().getNaziv().equals(Role.ADMIN);
	}

}