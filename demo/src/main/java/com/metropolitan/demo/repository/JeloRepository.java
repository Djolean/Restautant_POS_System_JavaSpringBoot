package com.metropolitan.demo.repository;

import com.metropolitan.demo.entity.Jelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JeloRepository extends JpaRepository<Jelo, Integer> {

}