package com.metropolitan.demo.repository;

import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.entity.Sto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoRepository extends JpaRepository<Sto, Integer> {

    Sto findByNarudzbina_Id(Integer narudzbinaId);
    @Query("SELECT s.zauzeto FROM Sto s WHERE s.id = :id")
    boolean getZauzetoValueById(@Param("id") Sto stoId);
}
