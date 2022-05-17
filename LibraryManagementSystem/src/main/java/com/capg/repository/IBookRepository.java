package com.capg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.models.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> getBookBybookName(String bookName);
	List<Book> getBookBybookAuthor(String bookAuthor);
	List<Book> getBookBybookPublisher(String bookPublisher);
	
}
