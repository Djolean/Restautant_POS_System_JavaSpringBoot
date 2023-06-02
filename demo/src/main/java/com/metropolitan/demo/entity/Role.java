package com.metropolitan.demo.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "role")
@RequiredArgsConstructor
public class Role implements Serializable {

	public static final String USER = "User";
	public static final String ADMIN = "Admin";
	@Id
	@Column(name = "role_id")
	private Integer id;
	@Column(name = "naziv")
	private String naziv;

	@Override
	public String toString() {
		return naziv;
	}
}