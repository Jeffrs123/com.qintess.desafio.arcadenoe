package com.qintess.arcadenoe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/atendimento")
public class AtendimentoController {

	@GetMapping
	public String getAtendimento() {
		return "API Atendimento";
	}
}
