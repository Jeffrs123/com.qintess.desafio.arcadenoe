package com.qintess.arcadenoe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.arcadenoe.dto.request.AtendimentoDTO;
import com.qintess.arcadenoe.dto.response.MessageResponseDTO;
import com.qintess.arcadenoe.entity.Atendimento;
import com.qintess.arcadenoe.service.AtendimentoService;
import com.qintess.arcadenoe.service.PetService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = {
		"http://localhost:4200", 
		"https://arcadenoecliente.herokuapp.com"
		})
@RestController
@RequestMapping("/api/v1/atendimento")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtendimentoController {
	
	private AtendimentoService atendimentoService;
	
	@Autowired
	public AtendimentoController(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}

//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public MessageResponseDTO create(@RequestBody @Valid AtendimentoDTO atendimentoDTO) {
//		return atendimentoService.create(atendimentoDTO);
//	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody Atendimento atendimento) {
		return atendimentoService.create(atendimento);
	}
}
