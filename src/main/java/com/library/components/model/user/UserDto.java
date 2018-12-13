package com.library.components.model.user;

import lombok.Data;

@Data
public class UserDto {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String isBanned;
	private String userRole;
}
