package com.library.components.model.article;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.library.components.model.articlecomment.ArticleComment;
import com.library.components.model.user.User;
import com.library.components.model.vote.Vote;

import lombok.Data;

@Entity
@Data
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String shortDescription;
	private String text;
	@OneToMany(mappedBy="article")
	private List<ArticleComment> articleComments=new ArrayList<>();
	@OneToMany(mappedBy="article")
	private List<Vote> votes=new ArrayList<>();
	@ManyToMany(mappedBy="articles")
	private List<User> users;
	
	
	
}
