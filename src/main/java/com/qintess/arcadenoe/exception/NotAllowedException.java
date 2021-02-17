package com.qintess.arcadenoe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class NotAllowedException extends Exception {

	public NotAllowedException (Long pathId, Long objectId) {
		super("Operação não autorizada. O parâmetro id da URL ("+ pathId +") e Id no corpo da mensagem ("  + objectId + ") são diferentes");
	}
}
