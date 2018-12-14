package com.library.components.model.book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.components.model.bookauthor.BookAuthorDto;
import com.library.components.model.bookauthor.BookAuthorService;

@Service
public class BookMapper {

	private BookAuthorService bookAuthorService;
	
	@Autowired
	public BookMapper(BookAuthorService bookAuthorService) {
		this.bookAuthorService=bookAuthorService;
	}
	
	public BookDto toDto(Book book) {
		Optional<BookAuthorDto> bookAuthor=bookAuthorService.getById(book.getBookAuthor().getId());
		BookDto dto = new BookDto();
		dto.setId(book.getId());
		dto.setBookName(book.getBookName());
		dto.setBookAuthorId(book.getBookAuthor().getId());
		dto.setDatePublished(book.getDatePublished());
		dto.setISBN(book.getISBN());
		dto.setLibraryId(book.getLibrary().getId());
		dto.setBookAuthorId(book.getBookAuthor().getId());
		bookAuthor.ifPresent(bookA->{
			dto.setBookAuthorFirstName(bookA.getFirstName());
			dto.setBookAuthorLastName(bookA.getLastName());
		});
		return dto;
	}

//	public Book toEntity(BookDto dto) {
//		Book book=new Book();
//		book.setId(dto.getId());
//		book.setBookName(dto.getBookName());
//		book.setBookAuthor(dto.getBookAuthorId());//musi sprawdzic autora pod danym Id w bazie danych
//		
//		return book;
//	}
}
