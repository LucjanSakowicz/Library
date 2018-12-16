package com.library.components.model.bookauthor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookAuthorMapper {


	public BookAuthorDto toDto(BookAuthor bookAuthor) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(bookAuthor, BookAuthorDto.class);
	}

	public BookAuthor toEntity(BookAuthorDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, BookAuthor.class);

	}
	
}