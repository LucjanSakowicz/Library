package com.library.components.model.assignment;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.library.components.model.book.Book;
import com.library.components.model.user.User;

import lombok.Data;
@Entity
@Data
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime start;
	private LocalDateTime dueTime;
	private LocalDateTime end;
	@ManyToOne
	private Book book;
	@ManyToOne
	private User user;
	
	
	
	
}
