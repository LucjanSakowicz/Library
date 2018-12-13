package com.library.components.model.userrole;

import java.time.LocalDate;

import lombok.Data;
@Data
public class UserRoleDto {
	private Long id;
	private LocalDate dateCreated;
	private LocalDate dateDeleted;
	private String userRoleName;
}
