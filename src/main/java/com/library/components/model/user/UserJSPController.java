package com.library.components.model.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.utils.profiles.DevJSP;

@DevJSP
@Controller
@RequestMapping("/users")
public class UserJSPController {

	private UserService userService;
	
	@Autowired
	public UserJSPController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/{id}")
	public String getUserDetails(@PathVariable Long id, Model model) {
	Optional<UserDto> dto=userService.getUserById(id);
	dto.ifPresent(user->{
		model.addAttribute("user",user);
	});
	return "user/user";
	}
	
	@GetMapping("")
	public String home(Model model) {
		List<UserDto> userList=userService.getAllUsers();
		model.addAttribute("userList", userList);
		return "user/users";
	}
	
}
