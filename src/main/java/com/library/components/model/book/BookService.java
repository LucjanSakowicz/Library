package com.library.components.model.book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.library.components.model.book.BookDto;
import com.library.components.model.book.BookMapper;
import com.library.components.model.book.BookRepository;
import com.library.utils.profiles.DevJSP;

@DevJSP
@Service
public class BookService {
	
	private BookRepository bookRepository;
	private BookMapper bookMapper;
	
	public BookService(BookRepository bookRepository, BookMapper bookMapper) {
		this.bookRepository=bookRepository;
		this.bookMapper=bookMapper;
	}
	public List<BookDto> getAllBooks() {
		return bookRepository.findAll().stream().map(bookMapper::toDto).collect(Collectors.toList());	
	}
	public Optional<BookDto> getBookById(Long id) {
		return bookRepository.findById(id).map(bookMapper::toDto);
	}

}
