package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.exception.BookNotFoundException;
import com.capg.models.Book;
import com.capg.repository.IBookRepository;
@Service
public class BookServiceImpl implements IBookService{
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		
		return bookRepository.save(book);
	}

	

	@Override
	public List<Book> viewBook() {
		List<Book> book = new ArrayList<Book>();
		bookRepository.findAll().forEach(b1 -> book.add(b1));
		return book;
	}

	@Override
	public Book updatebook(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public void removeBook(int bookId) {
		if(bookRepository.findById(bookId).isPresent()) {
		bookRepository.deleteById(bookId);
		}
		else {
			throw new BookNotFoundException("Book with Id : "+bookId+" was not found");
		}
	}
	
	@Override
	public Book viewBookById(int bookId) {
		return bookRepository.findById(bookId)
				.orElseThrow(()->new BookNotFoundException("Book with Id : "+bookId+" was not found"));
	}

	@Override
	public List<Book> viewByBookAuthor(String bookAuthor) {
		return bookRepository.getBookBybookAuthor(bookAuthor);
		
	}

	@Override
	public List<Book> viewByBookPublisher(String bookPublisher) {
		return bookRepository.getBookBybookPublisher(bookPublisher);
	}

	@Override
	public List<Book> viewByBookName(String bookName) {
		return bookRepository.getBookBybookName(bookName);
	}
	
	
}
