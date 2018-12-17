package com.library.components.model.book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.utils.converters.LocalDateConverter;
import com.library.utils.messages.Message;
import com.library.utils.profiles.DevJSP;

@DevJSP
@Controller
@RequestMapping("/books")
public class BookJSPController {
	private BookService bookService;

	@Autowired
	public BookJSPController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("")
	public String home(Model model) {
		List<BookDto> bookList = bookService.getAllBooks();
		model.addAttribute("bookList", bookList);
		return "book/books";
	}

	@GetMapping("/{id}")
	public String getBookDetails(@PathVariable Long id, Model model) {
		Optional<BookDto> dto = bookService.getBookById(id);
		dto.ifPresent(book -> {
			model.addAttribute("book", book);
		});
		return "book/book";
	}

	@GetMapping("/add")
	public String addBookForm(@RequestParam(required = false) Long bookAuthorId,
			@RequestParam(required = false) Long libraryId, Model model) {
		if (bookAuthorId != null)
			model.addAttribute("bookAuthorId", bookAuthorId);
		if (libraryId != null)
			model.addAttribute("libraryId", libraryId);
		return "book/bookaddform";
	}

	@PostMapping("/add")
	public String saveBook(@RequestParam String bookName, @RequestParam String datePublishedString,
			@RequestParam Long ISBN, @RequestParam Long bookAuthorId, @RequestParam Long libraryId, Model model) {
		// problem przy zamianie String->localDate?
		LocalDate datePublished = LocalDateConverter.stringToLocalDate(datePublishedString);
		BookDto bookDto = new BookDto();
		bookDto.setBookName(bookName);
		bookDto.setDatePublished(datePublished);
		bookDto.setISBN(ISBN);
		bookDto.setBookAuthorId(bookAuthorId);
		bookDto.setLibraryId(libraryId);
		Optional<BookDto> bookSaved = bookService.saveBook(bookDto);
		bookSaved.ifPresent(u -> {
			model.addAttribute("message", new Message("Sukces!", "Operacja dodania książki zakończyła się sukcesem!"));
		});
		// error -> do dopracowania na pozniej
		return bookSaved.map(u -> "message/success").orElse("message/error");
	}
	@GetMapping("/edit/{id}")
	public String editBookForm(@PathVariable Long id,Model model) {
		Optional<BookDto> bookDto=bookService.getBookById(id);
		bookDto.ifPresent(book->{
				model.addAttribute("book",book);
		});
		return bookDto.map(u->"book/bookeditform").orElse("message/error");
	}
	@PostMapping("/edit")
	public String updateBook(@RequestParam Long bookId, @RequestParam String bookName, @RequestParam String datePublishedString,
			@RequestParam Long ISBN, @RequestParam Long bookAuthorId, @RequestParam Long libraryId, Model model) {	
		LocalDate datePublished = LocalDateConverter.stringToLocalDate(datePublishedString);
		BookDto bookDto = new BookDto();
		bookDto.setId(bookId);
		bookDto.setBookName(bookName);
		bookDto.setDatePublished(datePublished);
		bookDto.setISBN(ISBN);
		bookDto.setBookAuthorId(bookAuthorId);
		bookDto.setLibraryId(libraryId);
		Optional<BookDto> bookEdited = bookService.saveBook(bookDto);
		bookEdited.ifPresent(u -> {
			model.addAttribute("message", new Message("Sukces!", "Operacja dodania książki zakończyła się sukcesem!"));
		});
		// error -> do dopracowania na pozniej
		return bookEdited.map(u -> "message/success").orElse("message/error");
	}
	@GetMapping("/delete/{id}")
	public String deleteBookForm(@PathVariable Long id,Model model) {
		Optional<BookDto> bookDto=bookService.getBookById(id);
		bookDto.ifPresent(book->{
				model.addAttribute("book",book);
		});
		return bookDto.map(u->"book/bookdeleteform").orElse("message/error");
	}
	@PostMapping("/delete")
	public String deleteBook(@RequestParam Long bookId) {
		Optional<BookDto> bookDeleted=bookService.deleteBook(bookId);		
		return bookDeleted.map(u -> "message/error").orElse("message/success");
	}
}
