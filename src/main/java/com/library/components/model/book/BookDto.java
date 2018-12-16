package com.library.components.model.book;


import java.time.LocalDate;

import lombok.Data;

@Data
public class BookDto {
	private Long id;
	private String bookName;
	private LocalDate datePublished;
	private Long ISBN;
	private Long bookAuthorId;
	private String bookAuthorFirstName;
	private String bookAuthorLastName;
	private Long libraryId;
	
	
}
