package com.library.components.model.bookcomment;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookCommentMapper {
	public BookCommentDto toDto(BookComment bookComment) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(bookComment, BookCommentDto.class);
	}

	public BookComment toEntity(BookCommentDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, BookComment.class);
	}
	
}
