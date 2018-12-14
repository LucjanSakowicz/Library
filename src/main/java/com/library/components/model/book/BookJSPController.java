package com.library.components.model.book;

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
@RequestMapping("/books")
public class BookJSPController {

	private BookService bookService;
	
	@Autowired
	public BookJSPController(BookService bookService) {
		this.bookService=bookService;
	}
	
	
	@GetMapping("/{id}")
	public String getBookDetails(@PathVariable Long id, Model model) {
	Optional<BookDto> dto=bookService.getBookById(id);
	dto.ifPresent(book->{
		model.addAttribute("book",book);
	});
	return "book";
	}
	@GetMapping("")
	public String home(Model model) {
		List<BookDto> bookList=bookService.getAllBooks();
		model.addAttribute("bookList", bookList);
		return "books";
	}
}
