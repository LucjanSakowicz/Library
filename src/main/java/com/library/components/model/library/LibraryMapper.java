package com.library.components.model.library;

import org.springframework.stereotype.Service;

@Service
public class LibraryMapper {

	
	public LibraryDto toDto(Library library) {
		LibraryDto dto=new LibraryDto();
		dto.setId(library.getId());
		dto.setAddress(library.getAddress());
		return dto;
	}
	public Library toEntity(LibraryDto dto) {
		Library entity=new Library();
		entity.setId(dto.getId());
		entity.setAddress(dto.getAddress());
		return entity;
	}
	
}
