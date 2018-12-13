package com.library.components.model.articlecomment;

import lombok.Data;
@Data
public class ArticleCommentDto {
	private Long id;
	private String shortDescription;
	private String text;
	private Long articleId;
	private Long userId;
}
