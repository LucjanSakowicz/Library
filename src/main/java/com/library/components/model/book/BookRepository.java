package com.library.components.model.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{



	List<Book> findAllByBookAuthor_Id(Long id);

	List<Book> findAllByLibrary_Id(Long id);




}
