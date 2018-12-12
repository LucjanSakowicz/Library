package com.library.components.model.book;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookDto {
	private Long id;
	private String BookName;
	private LocalDateTime DatePublished; //format daty '2017-10-08 15:00:00'
	private Long ISBN;
	private Long bookAuthorId;
	private Long libraryId;
	private Long assignmentId;
	private Long reviewId;
	private Long bookCommentId;
	private Long voteId;
}
