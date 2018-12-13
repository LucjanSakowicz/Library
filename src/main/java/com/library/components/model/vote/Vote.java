package com.library.components.model.vote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.library.components.model.article.Article;
import com.library.components.model.articlecomment.ArticleComment;
import com.library.components.model.book.Book;
import com.library.components.model.bookcomment.BookComment;
import com.library.components.model.bookreview.Review;
import com.library.components.model.reviewcomment.ReviewComment;
import com.library.components.model.user.User;

import lombok.Data;

@Entity
@Data
public class Vote {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private Integer voteUp;
		private Integer voteDown;
		@ManyToOne
		private ArticleComment articleComment;
		@ManyToOne
		private User user;
		@ManyToOne
		private ReviewComment reviewComment;
		@ManyToOne
		private BookComment bookComment;
		@ManyToOne
		private Review review;
		@ManyToOne
		private Book book;
		@ManyToOne
		private Article article;
		
	
}
