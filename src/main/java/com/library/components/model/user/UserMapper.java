package com.library.components.model.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.components.model.userrole.UserRole;
import com.library.components.model.userrole.UserRoleRepository;
@Service
public class UserMapper {

	private UserRoleRepository userRoleRepository;
	@Autowired
	public UserMapper(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}

	public UserDto toDto(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		if(user.getIsBanned()){
			dto.setIsBanned("zbanowany");
		}else if(!user.getIsBanned()) {
			dto.setIsBanned("aktywny");
		}
		dto.setUserRole(user.getUserRole().getUserRoleName());
		return dto;
	}

	public User toEntity(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		if(dto.getIsBanned().equals("zbanowany")) {
			user.setIsBanned(true);
		}else if(dto.getIsBanned().equals("aktywny")){
			user.setIsBanned(false);
		}
		Optional<UserRole> userRole = userRoleRepository.findByUserRoleName(dto.getUserRole());
		userRole.ifPresent(user::setUserRole);
		return user;
	}

}
