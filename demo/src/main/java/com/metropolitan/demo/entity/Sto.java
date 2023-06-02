package com.metropolitan.demo.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "sto")
public class Sto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sto_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "narudzbina_id", referencedColumnName = "narudzbina_id")
    private Narudzbina narudzbinaId;
}
