package com.library.components.model.library;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

	private LibraryRepository libraryRepository;
	private LibraryMapper libraryMapper;

	public LibraryService(LibraryRepository libraryRepository, LibraryMapper libraryMapper) {
		this.libraryRepository = libraryRepository;
		this.libraryMapper = libraryMapper;
	}

	public Optional<LibraryDto> getById(Long libraryId) {
		return libraryRepository.findById(libraryId).map(libraryMapper::toDto);
	}

}
