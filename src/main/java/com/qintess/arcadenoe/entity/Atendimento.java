package com.qintess.arcadenoe.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.qintess.arcadenoe.enums.Modalidade;
import com.qintess.arcadenoe.enums.Servicos;
import com.qintess.arcadenoe.enums.StatusAtendimento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@Builder
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Atendimento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate day;

	@Column(nullable = false)
	private LocalTime startTime;

	@Column(nullable = true)
	private LocalTime endTime;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Servicos tipoServico;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusAtendimento status;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Modalidade modalidade;

	@Column(nullable = true)
	private String observacao;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Pet pet;

//	public void setET() {
//		this.endTime = startTime.plusHours(1);	
//	}

	//	// Setter com lógica própria.
	public void setEndTime(LocalTime endTime) {
		this.endTime = startTime.plusHours(1);
	}

}
