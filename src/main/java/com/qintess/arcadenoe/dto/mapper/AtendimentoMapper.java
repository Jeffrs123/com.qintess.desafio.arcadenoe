package com.qintess.arcadenoe.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.qintess.arcadenoe.dto.request.AtendimentoDTO;
import com.qintess.arcadenoe.entity.Atendimento;

@Mapper//(componentModel = "spring") // Anotação que informa que é uma classe que o Mapper vai processar
public interface AtendimentoMapper {
	
	AtendimentoMapper INSTANCE = Mappers.getMapper( AtendimentoMapper.class );
//	AtendimentoMapper INSTANCE = Mappers.getMapper(AtendimentoMapper.class);

	
	@Mappings({
		@Mapping(target = "day", source = "day", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "startTime", source = "startTime", dateFormat = "HH:mm"),
		@Mapping(target="endTime", expression="java(atendimentodto.getStartTime().plusHours(1))")
		
	})
	Atendimento toModel(AtendimentoDTO atendimentodto);
	
	AtendimentoDTO toDTO(Atendimento atendimento);

}
