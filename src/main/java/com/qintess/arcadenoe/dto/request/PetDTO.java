package com.qintess.arcadenoe.dto.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.qintess.arcadenoe.entity.Atendimento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

	private Long id;
	
	@NotEmpty
	@Size(min = 5, max = 40)
	private String nome;
	
	@NotEmpty
	@Size(min = 5, max = 40)
	private String responsavel;

	@NotEmpty
	@Size(min = 1, max = 2)
	private int idade;
	
	private List<Atendimento> atendimentos;

	@Size(min = 1, max = 20)
	private String especie; // Criar classe Especie
	
	@Size(min = 1, max = 20)
	private String raca; // Criar classe Raça
}
