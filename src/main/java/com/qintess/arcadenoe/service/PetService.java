package com.qintess.arcadenoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.qintess.arcadenoe.dto.mapper.PetMapper;
import com.qintess.arcadenoe.dto.request.PetDTO;
import com.qintess.arcadenoe.dto.response.MessageResponseDTO;
import com.qintess.arcadenoe.entity.Pet;
import com.qintess.arcadenoe.repository.PetRepository;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {

	private final PetRepository petRepository;
	
//	private final PetMapper petMapper;// = PetMapper.INSTANCE;

	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
//	public MessageResponseDTO create(PetDTO petDTO) {
//		Pet petToSave = petMapper.toModel(petDTO);
//		
//		Pet pet = petRepository.save(petToSave);
//		
//		return MessageResponseDTO
//				.builder()
//				.message("Pet criado com ID " + pet.getId() + ".")
//				.build();
//	}
	
	public MessageResponseDTO create(Pet peta) {
		
		Pet pet = petRepository.save(peta);
		
		return MessageResponseDTO
				.builder()
				.message("Pet criado com ID " + pet.getId() + ".")
				.build();
	}
	
}
