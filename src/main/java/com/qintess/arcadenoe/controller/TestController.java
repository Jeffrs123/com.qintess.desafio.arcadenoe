package com.qintess.arcadenoe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {
		"http://localhost:4200", 
		"https://arcadenoecliente.herokuapp.com"
})
@RestController
@RequestMapping("/api/v1/teste")
public class TestController {

	@GetMapping
	public String getTest() {
		return "Teste Controller - Está funcionando";
	}
}
