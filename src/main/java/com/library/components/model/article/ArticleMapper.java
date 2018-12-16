package com.library.components.model.article;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ArticleMapper {
	public ArticleDto toDto(Article article) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(article, ArticleDto.class);
	}

	public Article toEntity(ArticleDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Article.class);
	}
}
