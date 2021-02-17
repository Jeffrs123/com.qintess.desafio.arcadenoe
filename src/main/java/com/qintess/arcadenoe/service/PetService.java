package com.qintess.arcadenoe.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.qintess.arcadenoe.dto.mapper.PetMapper;
import com.qintess.arcadenoe.dto.request.PetDTO;
import com.qintess.arcadenoe.dto.response.MessageResponseDTO;
import com.qintess.arcadenoe.entity.Pet;
import com.qintess.arcadenoe.exception.NotAllowedException;
import com.qintess.arcadenoe.exception.PetNotFoundException;
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

	//	public MessageResponseDTO create2(PetDTO petDTO) {
	//		Pet petToSave = petMapper.toModel(petDTO);
	//		
	//		Pet pet = petRepository.save(petToSave);
	//		
	//		return MessageResponseDTO
	//				.builder()
	//				.message("Pet criado com ID " + pet.getId() + ".")
	//				.build();
	//	}

	public MessageResponseDTO create(Pet pet) {

		Pet createdPet = petRepository.save(pet);
		return createMessageResponse(createdPet.getId(), "Pet criado com ID");
	}


	//	public List<PetDTO> listAll2() {
	//		List<Pet> allPet = petRepository.findAll();
	//		return allPet
	//				.stream()
	//				.map(petMapper::toDTO)
	//				.collect(Collectors.toList())
	//		;
	//	}

	public List<Pet> listAll() {
		List<Pet> allPet = petRepository.findAll();
		return allPet;
	}

	//	public Pet findById2(Long id) throws PetNotFoundException {
	//		  Pet pet = verifyIfExists(id);
	//		return petMapper.toDTO(pet);
	//	}

	public Pet findById(Long id) throws PetNotFoundException {
		Pet pet = verifyIfExists(id);
		return pet;
	}

	public void delete(Long id) throws PetNotFoundException {
		verifyIfExists(id);
		petRepository.deleteById(id);
	}

	

//	public MessageResponseDTO updateById2(Long id, PetDTO petDTO) throws PetNotFoundException {
//
//		verifyIfExists(id);
//
//		Pet petToUpdate = petMapper.toModel(petDTO);
//		
//		Pet updatedPet = petRepository.save(petToUpdate);
//
//		return createMessageResponse(updatedPet.getId(), "Pet atualizado com ID");
//	}


	public MessageResponseDTO updateById(Long id, Pet pet) throws PetNotFoundException, NotAllowedException {

		verifyIfExists(id);
		verifyPathVariableAndId(id, pet.getId());
		
		Pet updatedPet = petRepository.save(pet);

		return createMessageResponse(updatedPet.getId(), " Pet atualizado com ID    ");
	}
	
	private void verifyPathVariableAndId(Long id, Long petid) throws NotAllowedException{
		if (id != petid)
			throw new NotAllowedException(id, petid);
		
	}
	
	private Pet verifyIfExists(Long id) throws PetNotFoundException {
		return petRepository
				.findById(id)
				.orElseThrow(() -> new PetNotFoundException(id))
				;
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message.trim() + " " + id + ".")
				.build();
	}


}
