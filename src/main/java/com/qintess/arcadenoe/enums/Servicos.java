package com.qintess.arcadenoe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Servicos {

	BANHO(00, "Banho"),
	TOSA(01, "Tosa"),
	BANHOETOSA(02, "Banho e Tosa"),
	CONSULTA(03, "Consulta"),
	TREINAMENTO(04, "Treinamento"),
	HOSPEDAGEM(05, "Hospedagem");
	
	private final int cod;
	private final String descricao;
}
