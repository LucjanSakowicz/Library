package com.library.components.model.assignment;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AssignmentMapper {
	public AssignmentDto toDto(Assignment assignment) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(assignment, AssignmentDto.class);
	}

	public Assignment toEntity(AssignmentDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Assignment.class);
	}
}
