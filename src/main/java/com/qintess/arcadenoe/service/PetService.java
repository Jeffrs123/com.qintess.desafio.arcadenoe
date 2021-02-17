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
import com.qintess.arcadenoe.exception.UpdateNotAllowedException;
import com.qintess.arcadenoe.exception.PetNotFoundException;
import com.qintess.arcadenoe.repository.PetRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {

	private final PetRepository petRepository;

	private final PetMapper petMapper = PetMapper.INSTANCE;

	public MessageResponseDTO create(PetDTO petDTO) {
		
		Pet petToSave = petMapper.toModel(petDTO);
		Pet createdPet = petRepository.save(petToSave);
		
		return createMessageResponse(createdPet.getId(), "Pet criado com ID");
	}

	public List<PetDTO> listAll() {
		List<Pet> allPet = petRepository.findAll();
		return allPet
				.stream()
				.map(petMapper::toDTO)
				.collect(Collectors.toList())
				;
	}

	public PetDTO findById(Long id) throws PetNotFoundException {
		Pet pet = verifyIfExists(id);
		return petMapper.toDTO(pet);
	}

	public void delete(Long id) throws PetNotFoundException {
		verifyIfExists(id);
		petRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, PetDTO petDTO) throws PetNotFoundException, UpdateNotAllowedException {

		verifyIfExists(id);
		verifyPathVariableAndId(id, petDTO.getId());

		Pet petToUpdate = petMapper.toModel(petDTO);
		Pet updatedPet = petRepository.save(petToUpdate);
		
		return createMessageResponse(updatedPet.getId(), " Pet atualizado com ID    ");
	}

	private void verifyPathVariableAndId(Long id, Long petid) throws UpdateNotAllowedException{
		if (id != petid)
			throw new UpdateNotAllowedException(id, petid);

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
