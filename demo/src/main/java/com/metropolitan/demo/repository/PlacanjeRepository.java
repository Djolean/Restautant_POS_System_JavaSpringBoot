package com.metropolitan.demo.repository;


import com.metropolitan.demo.entity.Placanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacanjeRepository extends JpaRepository<Placanje, Integer> {

}