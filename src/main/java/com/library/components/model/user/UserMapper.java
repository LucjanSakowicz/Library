package com.library.components.model.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.library.components.model.user.User;
import com.library.components.model.user.UserDto;

@Service
public class UserMapper {

	public UserDto toDto(User user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, UserDto.class);
	}

	public User toEntity(UserDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, User.class);

	}

}
