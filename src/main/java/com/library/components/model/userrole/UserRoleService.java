package com.library.components.model.userrole;

import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class UserRoleService {
	
	private UserRoleRepository userRoleRepository;
	private UserRoleMapper userRoleMapper;
	
	public UserRoleService(UserRoleRepository userRoleRepository, UserRoleMapper userRoleMapper) {
		this.userRoleRepository=userRoleRepository;
		this.userRoleMapper=userRoleMapper;
	}
	
	public Optional<UserRoleDto> getUserRoleByName(String userRoleName) {
		return userRoleRepository.findByUserRoleName(userRoleName).map(userRoleMapper::toDto);
	}

	public Optional<UserRoleDto> getUserRoleById(Long userRoleId) {
		return userRoleRepository.findById(userRoleId).map(userRoleMapper::toDto);
	}


}
