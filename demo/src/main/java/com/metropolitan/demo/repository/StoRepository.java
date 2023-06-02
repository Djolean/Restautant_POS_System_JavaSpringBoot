package com.metropolitan.demo.repository;

import com.metropolitan.demo.entity.Sto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoRepository extends JpaRepository<Sto, Integer> {
}
