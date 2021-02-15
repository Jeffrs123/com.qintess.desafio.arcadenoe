package com.qintess.arcadenoe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Modalidade {
	
	EMERGENCIA("emergencia"),
	CONSULTA("consulta");
	
	private final String descricao;
	
}
