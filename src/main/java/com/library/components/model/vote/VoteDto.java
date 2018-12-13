package com.library.components.model.vote;

import lombok.Data;

@Data
public class VoteDto {
	
	private Long id;
	private Integer voteUp;
	private Integer voteDown;
	private Long articleCommentId;
	private Long userId;
	private Long reviewCommentId;
	private Long bookCommentId;
	private Long reviewId;
	private Long bookId;
	private Long articleId;
}
