package com.library.components.model.articlecomment;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ArticleCommentMapper {
	public ArticleCommentDto toDto(ArticleComment articleComment) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(articleComment, ArticleCommentDto.class);
	}

	public ArticleComment toEntity(ArticleCommentDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, ArticleComment.class);
	}
}
