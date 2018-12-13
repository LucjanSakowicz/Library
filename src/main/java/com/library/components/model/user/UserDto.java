package com.library.components.model.user;

import lombok.Data;

@Data
public class UserDto {
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean isBanned;
	private Long userRole;
}
