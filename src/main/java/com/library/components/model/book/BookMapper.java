package com.library.components.model.book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.components.model.bookauthor.BookAuthorDto;
import com.library.components.model.bookauthor.BookAuthorMapper;
import com.library.components.model.bookauthor.BookAuthorService;
import com.library.components.model.library.LibraryDto;
import com.library.components.model.library.LibraryMapper;
import com.library.components.model.library.LibraryService;

@Service
public class BookMapper {

	private BookAuthorService bookAuthorService;
	private BookAuthorMapper bookAuthorMapper;
	private LibraryService libraryService;
	private LibraryMapper libraryMapper;

	@Autowired
	public BookMapper(BookAuthorService bookAuthorService, BookAuthorMapper bookAuthorMapper,
			LibraryService libraryService, LibraryMapper libraryMapper) {
		this.bookAuthorService = bookAuthorService;
		this.bookAuthorMapper = bookAuthorMapper;
		this.libraryService = libraryService;
		this.libraryMapper = libraryMapper;
	}

	public BookDto toDto(Book book) {
		Optional<BookAuthorDto> bookAuthor = bookAuthorService.getById(book.getBookAuthor().getId());
		BookDto dto = new BookDto();
		dto.setId(book.getId());
		dto.setBookName(book.getBookName());
		dto.setDatePublished(book.getDatePublished());
		dto.setISBN(book.getISBN());
		dto.setBookAuthorId(book.getBookAuthor().getId());
		dto.setLibraryId(book.getLibrary().getId());
		bookAuthor.ifPresent(bookA -> {
			dto.setBookAuthorFirstName(bookA.getFirstName());
			dto.setBookAuthorLastName(bookA.getLastName());
		});
		return dto;
	}

	public Book toEntity(BookDto dto) {
		Book book = new Book();
		Optional<BookAuthorDto> bookAuthorDto = bookAuthorService.getById(dto.getBookAuthorId());
		Optional<LibraryDto> libraryDto = libraryService.getById(dto.getLibraryId());
		book.setId(dto.getId());
		book.setBookName(dto.getBookName());
		book.setDatePublished(dto.getDatePublished());
		book.setISBN(dto.getISBN());
		bookAuthorDto.ifPresent(author -> {
			book.setBookAuthor(bookAuthorMapper.toEntity(author));
		});
		libraryDto.ifPresent(library->{
			book.setLibrary(libraryMapper.toEntity(library));
		});

		return book;
	}
}