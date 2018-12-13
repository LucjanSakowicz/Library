package com.library.components.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.library.components.model.article.Article;
import com.library.components.model.articlecomment.ArticleComment;
import com.library.components.model.assignment.Assignment;
import com.library.components.model.bookcomment.BookComment;
import com.library.components.model.bookreview.Review;
import com.library.components.model.userrole.UserRole;
import com.library.components.model.vote.Vote;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Boolean isBanned;
	@ManyToOne
	private UserRole userRole;
	@OneToMany(mappedBy="user")
	private List<Assignment> assignments=new ArrayList<>();
	@OneToMany(mappedBy="user")
	private List<Review> reviews=new ArrayList<>();
	@OneToMany(mappedBy="user")
	private List<BookComment> bookComments=new ArrayList<>();
	@OneToMany(mappedBy="user")
	private List<Vote> votes=new ArrayList<>();
	@OneToMany(mappedBy="user")
	private List<Article> articles=new ArrayList<>();
	@OneToMany(mappedBy="user")
	private List<ArticleComment> articleComments=new ArrayList<>();
	
	
	
}
