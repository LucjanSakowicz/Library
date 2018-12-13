package com.library.components.model.bookcomment;

import lombok.Data;
@Data
public class BookCommentDto {
	private Long id;
	private String shortDescription;
	private String text;
	private Long bookId;
	private Long userId;
}
