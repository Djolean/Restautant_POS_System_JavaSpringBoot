package com.metropolitan.demo.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "narudzbina")
public class Narudzbina implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "narudzbina_id")
	private Integer id;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "korisnik_id", referencedColumnName = "korisnik_id")
	private Korisnik korisnikId;
	@Column(name = "datum")
	private LocalDate datum;
	@Column(name = "ukupna_cena")
	private Double ukupnaCena;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Jelo> jelos;
}