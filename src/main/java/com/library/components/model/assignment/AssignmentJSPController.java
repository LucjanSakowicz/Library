package com.library.components.model.assignment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.components.model.book.BookService;
import com.library.components.model.user.UserService;
import com.library.utils.profiles.DevJSP;

@DevJSP
@Controller
@RequestMapping("/assignments")
public class AssignmentJSPController {

	private AssignmentService assignmentService;
	private BookService bookService;
	private UserService userService;
	
	
	public AssignmentJSPController(AssignmentService assignmentService, BookService bookService, UserService userService) {
		this.assignmentService=assignmentService;
		this.bookService=bookService;
		this.userService=userService;
	}
	
	@GetMapping("/borrow/{id}")
	public String borrowBook(@PathVariable Long id, Model model) {
		
		return "success";
	}
	
}
