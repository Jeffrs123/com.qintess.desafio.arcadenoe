package com.qintess.arcadenoe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusAtendimento {
	
	MARCADO("Marcado"),
	CONCLUIDO("Concluido"),
	CANCELADO("Cancelado"),
	EMATENDIMENTO("Em atendimento");
	
	private final String descricao;
}
