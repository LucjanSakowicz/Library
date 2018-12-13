package com.library.components.model.reviewcomment;

import lombok.Data;

@Data
public class ReviewCommentDto {
	private Long id;
	private String shortDescription;
	private String text;
	private Long reviewId;
	private Long userId;
}
