package com.library.components.model.user;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import com.library.components.model.userrole.UserRole;


@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	private UserService userService;
	private UserMapper userMapper;
	
	@Autowired
	public void setUserRepository(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper=userMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDto> userDto = userService.getUserByUserName(username);
		if(!userDto.isPresent())
			throw new UsernameNotFoundException("Nie ma takiego użytkownika");
		User user=userMapper.toEntity(userDto.get());
		org.springframework.security.core.userdetails.User userDetails = 
				new org.springframework.security.core.userdetails.User(
						user.getUserName(), 
						user.getPassword(), 
						convertAuthorities(user.getUserRole()));
		return userDetails;
	}
	
	private Set<GrantedAuthority> convertAuthorities(UserRole userRole) {
		Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority(userRole.getUserRoleName()));

		return authorities;
	}
}