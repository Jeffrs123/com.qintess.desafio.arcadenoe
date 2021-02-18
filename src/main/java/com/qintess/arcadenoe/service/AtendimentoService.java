package com.qintess.arcadenoe.service;

import java.util.List;
import java.util.stream.Collectors;

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
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtendimentoService {

	private final AtendimentoRepository atendimentoRepository;

	private final AtendimentoMapper atendimentoMapper = AtendimentoMapper.INSTANCE;


	public MessageResponseDTO create( AtendimentoDTO atendimentoDTO) {

		Atendimento atendimentoToSave = atendimentoMapper.toModel(atendimentoDTO);
		atendimentoToSave.setEndTime(atendimentoToSave.getStartTime());

		Atendimento createdAtendimento = atendimentoRepository.save(atendimentoToSave);

		return createMessageResponse(createdAtendimento.getId(), "Atendimento criado com ID");
	}
	
	public List<AtendimentoDTO> listAll() {
		List<Atendimento> allAtendimento = atendimentoRepository.findAll();
		return allAtendimento
				.stream()
				.map(atendimentoMapper::toDTO)
				.collect(Collectors.toList())
				;
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message.trim() + " " + id + ".")
				.build();
	}
}
