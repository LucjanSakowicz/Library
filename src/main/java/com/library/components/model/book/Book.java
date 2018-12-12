package com.library.components.model.book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.library.components.model.assignment.Assignment;
import com.library.components.model.bookauthor.BookAuthor;
import com.library.components.model.bookcomment.BookComment;
import com.library.components.model.bookreview.Review;
import com.library.components.model.library.Library;
import com.library.components.model.vote.Vote;
import lombok.Data;

@Entity
@Data
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String BookName;
	private LocalDateTime DatePublished; //format daty '2017-10-08 15:00:00'
	private Long ISBN;
	@ManyToOne
	private BookAuthor bookAuthor;
	@ManyToOne
	private Library library;
	@OneToMany(mappedBy="book")
	private List<Assignment> assignments=new ArrayList<>();
	@OneToMany(mappedBy="book")
	private List<Review> reviews=new ArrayList<>();
	@OneToMany(mappedBy="book")
	private List<BookComment> bookComments=new ArrayList<>();
	@OneToMany(mappedBy="book")
	private List<Vote> votes=new ArrayList<>();
	
}
