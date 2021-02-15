package com.qintess.arcadenoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.arcadenoe.dto.response.MessageResponseDTO;
import com.qintess.arcadenoe.entity.Pet;
import com.qintess.arcadenoe.repository.PetRepository;

@Service
public class PetService {

	private PetRepository petRepository;

	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public MessageResponseDTO create(Pet objeto) {
		Pet ob = petRepository.save(objeto);
		return MessageResponseDTO
				.builder()
				.message("Pet criado com ID " + ob.getId() + ".")
				.build();
	}
	
}
