package com.library.components.model.bookauthor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.library.components.model.book.Book;

import lombok.Data;

@Entity
@Data
public class BookAuthor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy="bookAuthor")
	private List<Book> books = new ArrayList<>();
	
}
