package com.library.components.model.reviewcomment;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReviewCommentMapper {

	public ReviewCommentDto toDto(ReviewComment reviewComment) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(reviewComment, ReviewCommentDto.class);
	}

	public ReviewComment toEntity(ReviewCommentDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, ReviewComment.class);
	}
}
