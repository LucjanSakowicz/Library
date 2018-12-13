package com.library.components.model.bookreview;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.library.components.model.book.Book;
import com.library.components.model.reviewcomment.ReviewComment;
import com.library.components.model.user.User;
import com.library.components.model.vote.Vote;

import lombok.Data;

@Entity
@Data
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String shortDescription;
	private String text;
	@OneToMany(mappedBy="review")
	private List<Vote> votes=new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	@OneToMany(mappedBy="review")
	private List<ReviewComment> reviewComments=new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
}
