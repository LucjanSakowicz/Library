package com.library.components.model.book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.library.utils.profiles.DevJSP;

@DevJSP
@Service
public class BookService {

	private BookRepository bookRepository;
	private BookMapper bookMapper;

	public BookService(BookRepository bookRepository, BookMapper bookMapper) {
		this.bookRepository = bookRepository;
		this.bookMapper=bookMapper;

	}

	public List<BookDto> getAllBooks() {
		return bookRepository.findAll().stream().map(bookMapper::toDto).collect(Collectors.toList());	
	}

	public Optional<BookDto> getBookById(Long id) {
		return bookRepository.findById(id).map(bookMapper::toDto);
	}

	public List<BookDto> getAllBooksByAuthorId(Long id) {
		return bookRepository.findAllByBookAuthor_Id(id).stream().map(bookMapper::toDto).collect(Collectors.toList());
	}

	public Optional<BookDto> saveBook(BookDto bookDto) {
		Book bookToSave = bookMapper.toEntity(bookDto);
		
		// tu powinna byc walidacja danych!

		return Optional.of(bookMapper.toDto(bookRepository.save(bookToSave)));
	}

	public List<BookDto> getAllBooksByLibraryId(Long id) {
		return bookRepository.findAllByLibrary_Id(id).stream().map(bookMapper::toDto).collect(Collectors.toList());
	}

	public Optional<BookDto> deleteBook(Long id) {
		Optional<Book> bookToDelete=bookRepository.findById(id);
		bookToDelete.ifPresent(book->{
			bookRepository.delete(book);
		});
		return bookRepository.findById(id).map(bookMapper::toDto);
	}

}
