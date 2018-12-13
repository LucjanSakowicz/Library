package com.library.components.model.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.library.utils.profiles.DevJSP;

@DevJSP
@Service
public class UserJSPService {

	private UserRepository userRepository;
	private UserMapper userMapper;
	
	public UserJSPService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository=userRepository;
		this.userMapper=userMapper;
	}
	
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
		
	}

}
