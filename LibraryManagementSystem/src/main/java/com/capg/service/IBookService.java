package com.capg.service;

import java.util.List;

import com.capg.models.Book;

public interface IBookService {
	Book createBook(Book book);
	
	Book viewBookById(int bookId);
	
	List<Book> viewBook();
	
	Book updatebook(Book book);
	
	void removeBook(int bookId);
	
	List<Book>viewByBookAuthor(String bookAuthor);
	
	List<Book>viewByBookPublisher(String bookPublisher);
	
	List<Book>viewByBookName(String bookName);
}
