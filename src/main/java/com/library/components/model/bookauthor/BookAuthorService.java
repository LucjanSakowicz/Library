package com.library.components.model.bookauthor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookAuthorService {

	private BookAuthorRepository bookAuthorRepository;
	private BookAuthorMapper bookAuthorMapper;
	
	@Autowired
	public BookAuthorService(BookAuthorRepository bookAuthorRepository,BookAuthorMapper bookAuthorMapper) {
		this.bookAuthorRepository=bookAuthorRepository;
		this.bookAuthorMapper=bookAuthorMapper;
	}
	
	public Optional<BookAuthorDto> getById(Long bookAuthorId) {
		return bookAuthorRepository.findById(bookAuthorId).map(bookAuthorMapper::toDto);
	}



}