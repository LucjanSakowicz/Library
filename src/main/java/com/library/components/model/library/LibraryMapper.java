package com.library.components.model.library;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.library.components.model.library.Library;
import com.library.components.model.library.LibraryDto;

@Service
public class LibraryMapper {

	public LibraryDto toDto(Library library) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(library, LibraryDto.class);
	}

	public Library toEntity(LibraryDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Library.class);

	}

}
