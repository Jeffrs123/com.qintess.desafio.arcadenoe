package com.qintess.arcadenoe.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.qintess.arcadenoe.dto.request.PetDTO;
import com.qintess.arcadenoe.entity.Pet;

@Mapper//(componentModel = "spring")
public interface PetMapper {

	PetMapper INSTANCE = Mappers.getMapper( PetMapper.class );

	Pet toModel(PetDTO pet);
	
	PetDTO toDTO(Pet pet);
	
	
	
//	private Pet petToGoToDTO(PetDTO petDTO) {
//		
//		Pet petToGoToDTO = Pet.builder()
//				.nome(petDTO.getNome())
//				.responsavel(petDTO.getResponsavel())
//				.idade(petDTO.getIdade())
//				.especie(petDTO.getEspecie())
//				.raca(petDTO.getRaca())
//				.atendimentos(petDTO.getAtendimentos())
//				.build()
//				;
//		
//		return petToGoToDTO;
//	}
}
