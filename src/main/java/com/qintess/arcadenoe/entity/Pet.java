package com.qintess.arcadenoe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String responsavel; // Criar classe Cliente/Dono/Responsavel do Pet.

	@Column(nullable = false)
	private int idade;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Atendimento> atendimentos;

	@Column(nullable = true)
	private String especie; // Criar classe Especie
	
	@Column(nullable = true)
	private String raca; // Criar classe Raça

}
