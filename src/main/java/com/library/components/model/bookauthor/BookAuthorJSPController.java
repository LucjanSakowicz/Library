package com.library.components.model.bookauthor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.components.model.book.BookDto;
import com.library.components.model.book.BookService;
import com.library.utils.profiles.DevJSP;

@DevJSP
@Controller
@RequestMapping("/authors")
public class BookAuthorJSPController {

	private BookAuthorService bookAuthorService;
	private BookService bookService;
	
	public BookAuthorJSPController(BookAuthorService bookAuthorService, BookService bookService) {
		this.bookAuthorService=bookAuthorService;
		this.bookService=bookService;
	}
	
	@GetMapping("/{id}")
	public String getAuthorDetails(@PathVariable Long id, Model model) {
		List<BookDto> books=bookService.getAllBooksByAuthorId(id);
		Optional<BookAuthorDto> bookAuthorDto=bookAuthorService.getById(id);
		bookAuthorDto.ifPresent(author->{
			model.addAttribute("author",author);
			model.addAttribute("books",books);
		});
		return "author/author";
	}
}
