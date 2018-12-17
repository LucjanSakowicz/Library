package com.library;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.components.model.user.UserDto;
import com.library.components.model.user.UserService;
import com.library.utils.messages.Message;
import com.library.utils.profiles.DevJSP;

@DevJSP
@Controller
@RequestMapping("")
public class HomeController {
	
private UserService userService;

public HomeController(UserService userService) {
	this.userService=userService;
}

	@GetMapping("")
	public String home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication.getAuthorities());
		if (authentication == null) {	
		}
		Object principalObject = authentication.getPrincipal();
		if (principalObject == null) {
		//not authorized
		}
		return "index";
	}
	
	@GetMapping("/register")
	public String registerUserForm(Model model) {
		model.addAttribute("userDto", new UserDto());
		return "home/userregisterform";
	}
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute("userDto") @Valid UserDto userdto,
			BindingResult bindResult, Model model) {
		System.out.println("IMIE "+userdto.getFirstName());
		if(bindResult.hasErrors())
			return "home/userregisterform";
		else {
			userService.saveUser(userdto);
			model.addAttribute("message",new Message("Sukces","Uzytkownik zostal zarejestrowany"));
			return "message/success";
		}
	}
	@GetMapping("/loginform")
	public String loginForm() {
	    return "home/loginform";
	}

	
}
