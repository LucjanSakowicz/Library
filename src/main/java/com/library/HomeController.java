package com.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.utils.profiles.DevJSP;

@DevJSP
@Controller

public class HomeController {
	

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "LIBRARY APP");
		return "index";
	}
	


	
	
}
