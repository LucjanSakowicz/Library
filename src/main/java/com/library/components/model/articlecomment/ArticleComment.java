package com.library.components.model.articlecomment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.library.components.model.article.Article;
import com.library.components.model.user.User;
import com.library.components.model.vote.Vote;

import lombok.Data;

@Entity
@Data
public class ArticleComment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String shortDescription;
	private String text;
	@ManyToOne
	@JoinColumn(name="article_id")
	private Article article;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(mappedBy="articleComment")
	private List<Vote> votes=new ArrayList<>();
	
	
}
