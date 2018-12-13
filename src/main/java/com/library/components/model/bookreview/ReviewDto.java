package com.library.components.model.bookreview;

import lombok.Data;

@Data
public class ReviewDto {
	private Long id;
	private String shortDescription;
	private String text;
	private Long book;
	private Long user;
}
