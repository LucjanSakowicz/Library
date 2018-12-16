package com.library.components.model.bookreview;

import org.modelmapper.ModelMapper;


public class ReviewMapper {
	public ReviewDto toDto(Review review) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(review, ReviewDto.class);
	}

	public Review toEntity(ReviewDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Review.class);
	}
}
