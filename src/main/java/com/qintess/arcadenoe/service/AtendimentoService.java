package com.qintess.arcadenoe.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.qintess.arcadenoe.dto.mapper.AtendimentoMapper;
import com.qintess.arcadenoe.dto.request.AtendimentoDTO;
import com.qintess.arcadenoe.dto.response.MessageResponseDTO;
import com.qintess.arcadenoe.entity.Atendimento;
import com.qintess.arcadenoe.repository.AtendimentoRepository;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtendimentoService {

	private final AtendimentoRepository atendimentoRepository;

//	private final AtendimentoMapper atendimentoMapper = AtendimentoMapper.INSTANCE;

	@Autowired
	public AtendimentoService(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}

//	public MessageResponseDTO create( AtendimentoDTO atendimentoDTO) {
//
//		Atendimento atendimentoToSave = atendimentoMapper.toModel(atendimentoDTO);
//
//		Atendimento at = atendimentoRepository.save(atendimentoToSave);
//
//		return MessageResponseDTO
//				.builder()
//				.message("Atendimento criado com ID " + at.getId() + ".")
//				.build();
//	}
	public MessageResponseDTO create( Atendimento atendimento) {

		System.out.println("create atendimento normal");

		Atendimento at = atendimentoRepository.save(atendimento);

		return MessageResponseDTO
				.builder()
				.message("Atendimento criado com ID " + at.getId() + ".")
				.build();
	}
}
