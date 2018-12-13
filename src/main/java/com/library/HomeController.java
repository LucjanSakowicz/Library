package com.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.components.model.user.UserDto;
import com.library.components.model.user.UserJSPService;
import com.library.utils.profiles.DevJSP;

@DevJSP
@Controller
public class HomeController {

	private UserJSPService userJSPService;
	
	@Autowired
	public HomeController(UserJSPService userJSPService) {
		this.userJSPService=userJSPService;
	}
	
	
	@GetMapping("/")
	public String home(Model model) {
		List<UserDto> userList=userJSPService.getAllUsers();
		model.addAttribute("userList", userList);
		model.addAttribute("helloMessage","Hello! :)");
		return "index";
	}
	
	
}
