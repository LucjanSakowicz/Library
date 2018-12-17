package com.library.components.model.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.components.model.userrole.UserRoleDto;
import com.library.components.model.userrole.UserRoleService;
import com.library.utils.messages.Message;
import com.library.utils.profiles.DevJSP;

@DevJSP
@Controller
@RequestMapping("/users")
public class UserJSPController {

	private UserService userService;
	private UserRoleService userRoleService;
	

	@Autowired
	public UserJSPController(UserService userService, UserRoleService userRoleService) {
		this.userService = userService;
		this.userRoleService=userRoleService;
	}

	@GetMapping("")
	public String home(Model model) {
		List<UserDto> userList = userService.getAllUsers();
		model.addAttribute("userList", userList);
		return "user/users";
	}

	@GetMapping("/{id}")
	public String getUserDetails(@PathVariable Long id, Model model) {
		Optional<UserDto> dto = userService.getUserById(id);
		dto.ifPresent(user -> {
			model.addAttribute("user", user);
		});
		return "user/user";
	}

	@GetMapping("/add")
	public String addUserForm() {
		return "user/useraddform";
	}

	@PostMapping("/add")
	public String saveUser(@RequestParam String userName, @RequestParam String password, @RequestParam String email,
			@RequestParam String firstName, @RequestParam String lastName, Model model) {
		UserDto userDto = new UserDto();
		userDto.setUserName(userName);
		userDto.setEmail(email);
		userDto.setPassword(password);
		userDto.setFirstName(firstName);
		userDto.setLastName(lastName);
		Optional<UserDto> userSaved = userService.saveUser(userDto);
		userSaved.ifPresent(u -> {
			model.addAttribute("message",
					new Message("Sukces!", "Operacja dodania użytkownika zakończyła się sukcesem!"));
		});
		// error -> do dopracowania na pozniej
		return userSaved.map(u -> "message/success").orElse("message/error");
	}

	@GetMapping("/edit/{id}")
	public String editUserForm(@PathVariable Long id, Model model) {
		Optional<UserDto> userDto = userService.getUserById(id);
		userDto.ifPresent(user -> {
			model.addAttribute("user", user);
		});
		return userDto.map(u -> "user/usereditform").orElse("message/error");
	}

	@PostMapping("/edit")
	public String updateUser(@RequestParam Long userId, @RequestParam String userName,
			@RequestParam String password, @RequestParam String email, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String userRoleName, @RequestParam Boolean isBanned, Model model) {
		UserDto userDto = new UserDto();
		userDto.setId(userId);
		userDto.setUserName(userName);
		
		if ("".equals(password)) {
			Optional<UserDto> user=userService.getUserById(userId);
			user.ifPresent(u->{
				userDto.setPassword(u.getPassword());
			});
		}else {
			userDto.setPassword(password);
		}
		
		userDto.setEmail(email);
		userDto.setFirstName(firstName);
		userDto.setLastName(lastName);
		userDto.setIsBanned(isBanned);
		Optional<UserRoleDto> userRoleDto=userRoleService.getUserRoleByName(userRoleName);
		userRoleDto.ifPresent(userRole->{
			//ustawia Id, przez co nei jest tworzony nowy rekord
			userDto.setUserRoleId(userRole.getId());
			userDto.setUserRoleName(userRole.getUserRoleName());
			
		});
		Optional<UserDto> userEdited = userService.saveUser(userDto);
		userEdited.ifPresent(u -> {
			model.addAttribute("message", new Message("Sukces!", "Operacja dodania książki zakończyła się sukcesem!"));
		});
		return userEdited.map(u -> "message/success").orElse("message/error");
	}
	@GetMapping("/delete/{id}")
	public String deleteBookForm(@PathVariable Long id,Model model) {
		Optional<UserDto> userDto=userService.getUserById(id);
		userDto.ifPresent(user->{
				model.addAttribute("user",user);
		});
		return userDto.map(u->"user/userdeleteform").orElse("message/error");
	}
	@PostMapping("/delete")
	public String deleteBook(@RequestParam Long userId) {
		Optional<UserDto> bookDeleted=userService.deleteUser(userId);		
		return bookDeleted.map(u -> "message/error").orElse("message/success");
	}
}
