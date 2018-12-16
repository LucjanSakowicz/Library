package com.library.components.model.userrole;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserRoleMapper {
	public UserRoleDto toDto(UserRole userRole) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(userRole, UserRoleDto.class);
	}

	public UserRole toEntity(UserRoleDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, UserRole.class);
	}
}
