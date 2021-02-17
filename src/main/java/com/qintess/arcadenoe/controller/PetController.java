package com.qintess.arcadenoe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.arcadenoe.dto.request.PetDTO;
import com.qintess.arcadenoe.dto.response.MessageResponseDTO;
import com.qintess.arcadenoe.entity.Pet;
import com.qintess.arcadenoe.exception.NotAllowedException;
import com.qintess.arcadenoe.exception.PetNotFoundException;
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
	//	public MessageResponseDTO create2(@RequestBody @Valid PetDTO petDTO) {
	//		return petService.create(petDTO);
	//	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody Pet pet) {
		System.out.println("Vamos criar pet: " + pet);
		return petService.create(pet);
	}

	//	@GetMapping
	//	public List<PetDTO> listAll() {
	//		return petService.listAll2();
	//	}

	@GetMapping
	public List<Pet> listAll() {
		return petService.listAll();
	}

	//	@GetMapping("/{id}")
	//	public Pet findById2(@PathVariable Long id) throws PetNotFoundException {
	//		return petService.findById2(id);
	//	}

	@GetMapping("/{id}")
	public Pet findById(@PathVariable Long id) throws PetNotFoundException {
		return petService.findById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PetNotFoundException {
		petService.delete(id);
	}

	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody Pet pet) throws PetNotFoundException, NotAllowedException {
		return petService.updateById(id, pet);
	}
	
//	@PutMapping("/{id}")
//	public MessageResponseDTO updateById2(@PathVariable Long id, @RequestBody @Valid PetDTO petDTO) throws PetNotFoundException {
//		return petService.updateById2(id, petDTO);
//	}


}
