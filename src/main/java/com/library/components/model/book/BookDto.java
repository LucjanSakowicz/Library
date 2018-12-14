package com.library.components.model.book;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookDto {
	private Long id;
	private String bookName;
	private LocalDateTime datePublished;
	private Long ISBN;
	private Long bookAuthorId;
	private String bookAuthorFirstName;
	private String bookAuthorLastName;
	private Long libraryId;
	
	
}
