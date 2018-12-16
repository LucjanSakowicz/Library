package com.library.components.model.book;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

	public BookDto toDto(Book book) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(book, BookDto.class);
	}

	public Book toEntity(BookDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Book.class);
	}
}