package com.library.components.model.book;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookDto {
	private Long id;
	private String BookName;
	private LocalDateTime DatePublished;
	private Long ISBN;
	private Long bookAuthorId;
	private Long libraryId;

}
