package com.metropolitan.demo.repository;

import com.metropolitan.demo.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

    Korisnik findByIme(String ime);

}