package com.metropolitan.demo.service.impl;


import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.repository.JeloRepository;
import com.metropolitan.demo.service.JeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class JeloServiceImpl implements JeloService {
    private final JeloRepository jeloRepository;

    @Override
    public List<Jelo> findAll() {
        return jeloRepository.findAll();
    }

    @Override
    public Jelo findById(Integer jeloId) {
        return jeloRepository.findById(jeloId)
                .orElseThrow(() -> new NoSuchElementException("JeloService.notFound"));
    }

    @Override
    public Jelo save(Jelo jelo) {
        return jeloRepository.save(jelo);
    }

    @Override
    public Jelo update(Jelo jelo) {
        return jeloRepository.save(jelo);
    }

    @Override
    public void deleteById(Integer jeloId) {
        jeloRepository.deleteById(jeloId);
    }

    @Override
    public List<Jelo> sortJeloByPriceDesc(List<Jelo> jelos) {
        Collections.sort(jelos, Comparator.comparing(Jelo::getCena));
        return jelos;
    }

    @Override
    public List<Jelo> sortJeloByPriceAsc(List<Jelo> jelos) {
        Collections.sort(jelos, Comparator.comparing(Jelo::getCena).reversed());
        return jelos;
    }

    @Override
    public List<Jelo> sortJeloByNameAsc(List<Jelo> jelos) {
        Collections.sort(jelos, Comparator.comparing(Jelo::getNaziv));
        return jelos;
    }


    @Override
    public List<Jelo> sortJeloByNameDesc(List<Jelo> jelos) {
        Collections.sort(jelos, Comparator.comparing(Jelo::getNaziv).reversed());
        return jelos;
    }

}