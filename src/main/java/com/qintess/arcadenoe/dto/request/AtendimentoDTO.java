package com.qintess.arcadenoe.dto.request;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.qintess.arcadenoe.entity.Pet;
import com.qintess.arcadenoe.enums.Modalidade;
import com.qintess.arcadenoe.enums.Servicos;
import com.qintess.arcadenoe.enums.StatusAtendimento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoDTO {

	private Long id;
	
//	@NotEmpty
//	@CPF
//	private String cpf;
	
	@NotEmpty
	private String day;
	
	@NotEmpty
	private String startTime;
	
	// @NotEmpty
	private String endTime;
	
	@Enumerated(EnumType.STRING)
	@NotEmpty
	private Servicos tipoServico;
	
	@Enumerated(EnumType.STRING)
	@NotEmpty
	private StatusAtendimento status;
	
	@Enumerated(EnumType.STRING)
	@NotEmpty
	private Modalidade modalidade;
	
	@Size(min = 5, max = 500)  //	@NotEmpty //	@Column(nullable = true)
	private String observacao;
	
	@Valid
	@NotEmpty // @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PetDTO pet;
	
}
