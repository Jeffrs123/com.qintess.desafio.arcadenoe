package com.qintess.arcadenoe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.arcadenoe.dto.request.PetDTO;
import com.qintess.arcadenoe.dto.response.MessageResponseDTO;
import com.qintess.arcadenoe.entity.Pet;
import com.qintess.arcadenoe.service.PetService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = {
		"http://localhost:4200", 
		"https://arcadenoecliente.herokuapp.com"
		})
@RestController
@RequestMapping("/api/v1/pet")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetController {

	private final PetService petService;

	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}

//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public MessageResponseDTO create(@RequestBody @Valid PetDTO petDTO) {
//		return petService.create(petDTO);
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody Pet pet) {
		System.out.println("Vamos criar pet: " + pet);
		return petService.create(pet);
	}
	
}
