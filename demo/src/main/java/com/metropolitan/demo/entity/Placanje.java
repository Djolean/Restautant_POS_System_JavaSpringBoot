package com.metropolitan.demo.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "placanje")
public class Placanje implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "placanje_id")
	private Integer id;
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "narudzbina_id", referencedColumnName = "narudzbina_id")
	private Narudzbina narudzbinaId;
	@Column(name = "datum_placanja")
	private LocalDateTime datumPlacanja;
	@Column(name = "barkod")
	private UUID barCode;

}