package com.library.components.model.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.library.utils.profiles.DevJSP;



@DevJSP
@Service
public class UserService {

	private UserRepository userRepository;
	private UserMapper userMapper;
	
	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository=userRepository;
		this.userMapper=userMapper;
	}
	
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
		
	}

	public Optional<UserDto> getUserById(Long id) {
		return userRepository.findById(id).map(userMapper::toDto);
	}

}
