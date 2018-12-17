package com.library.components.model.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.library.components.model.userrole.UserRoleService;

@Service
public class UserMapper {

	private UserRoleService userRoleService;


	public UserMapper(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
		
	
	}

	public UserDto toDto(User user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, UserDto.class);
	}

	public User toEntity(UserDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		// workaround dla domyslnej wartosci isBanned - z jakiegos powodu
		// za kazdym razem tworzy false w DB niezależnie od użytej adnotacji
		// i typu zmiennej - do wyjaśnienia
		if (dto.getIsBanned() == null) {
			dto.setIsBanned(true);
		}
		//jak wyzej - ustawienie obiektu jako wartosci domyslnej? do wyjasnienia
		if (dto.getUserRoleName() == null) {
			userRoleService.getUserRoleById(2L).ifPresent(userRole -> {
				dto.setUserRoleName(userRole.getUserRoleName());
				dto.setUserRoleId(userRole.getId());
			});
		}
		return modelMapper.map(dto, User.class);

	}

}
