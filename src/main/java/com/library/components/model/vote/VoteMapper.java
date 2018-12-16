package com.library.components.model.vote;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VoteMapper {

	public VoteDto toDto(Vote vote) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(vote, VoteDto.class);
	}

	public Vote toEntity(VoteDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Vote.class);
	}

}
