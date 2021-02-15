package com.qintess.arcadenoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.qintess.arcadenoe.dto.response.MessageResponseDTO;
import com.qintess.arcadenoe.entity.Atendimento;
import com.qintess.arcadenoe.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

	private AtendimentoRepository atendimentoRepository;
	
	@Autowired
	public AtendimentoService(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}
	
	public MessageResponseDTO create(@RequestBody Atendimento atendimento) {
		Atendimento at = atendimentoRepository.save(atendimento);
		return MessageResponseDTO
				.builder()
				.message("Atendimento criado com ID " + at.getId() + ".")
				.build();
	}
}
