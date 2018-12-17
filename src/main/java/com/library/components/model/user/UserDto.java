package com.library.components.model.user;

import lombok.Data;

@Data
public class UserDto {
	private Long id;
	private String userName;
	private String firstName;
	private String password;
	private String email;
	private String lastName;
	private Boolean isBanned;
	private Long userRoleId;
	private String userRoleName;

}
