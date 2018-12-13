package com.library.components.model.userrole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.library.components.model.user.User;

import lombok.Data;

@Entity
@Data
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate dateCreated;
	private LocalDate dateDeleted;
	private String userRoleName;
	@OneToMany(mappedBy="userRole")
	private List<User> users=new ArrayList<>();
	
}
