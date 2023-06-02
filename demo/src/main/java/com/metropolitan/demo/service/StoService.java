package com.metropolitan.demo.service;

import com.metropolitan.demo.entity.Sto;

import java.util.List;

public interface StoService {
    List<Sto> findAll();

    Sto save(Sto sto);

    Sto update(Sto sto);

    Sto findById(Integer stoId);

    void deleteById(Integer stoId);
}
