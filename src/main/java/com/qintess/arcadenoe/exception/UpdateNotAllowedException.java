package com.qintess.arcadenoe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class UpdateNotAllowedException extends Exception {

	public UpdateNotAllowedException (Long pathId, Long objectId) {
		super("Não é possível atualizar. O parâmetro id da URL ("+ pathId +") e Id no corpo da mensagem ("  + objectId + ") são diferentes");
	}
}
