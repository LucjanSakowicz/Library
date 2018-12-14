package com.library.components.model.bookauthor;

import org.springframework.stereotype.Service;

@Service
public class BookAuthorMapper {

	public BookAuthorDto toDto(BookAuthor bookAuthor) {
		BookAuthorDto dto=new BookAuthorDto();
		dto.setId(bookAuthor.getId());
		dto.setFirstName(bookAuthor.getFirstName());
		dto.setLastName(bookAuthor.getLastName());		
		return dto;
	}
	public BookAuthor toEntity(BookAuthorDto dto) {
		BookAuthor bookAuthor=new BookAuthor();
		bookAuthor.setId(dto.getId());
		bookAuthor.setFirstName(dto.getFirstName());
		bookAuthor.setLastName(dto.getLastName());
		return bookAuthor;
	}
	
}
