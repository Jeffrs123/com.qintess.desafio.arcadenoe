package com.qintess.arcadenoe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://arcadenoecliente.herokuapp.com")
@RequestMapping("/api/v1/teste")
public class TestController {

	@GetMapping
	public String getTest() {
		return "Teste Controller - Está funcionando";
	}
}
