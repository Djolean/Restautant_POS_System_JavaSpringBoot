package com.metropolitan.demo.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "jelo")
@RequiredArgsConstructor
public class Jelo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jelo_id", nullable = false)
	private Integer id;
	@Column(name = "naziv")
	private String naziv;
	@Column(name = "cena")
	private Double cena;
	@Column(name = "opis")
	private String opis;


}