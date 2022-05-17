package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.models.Book;
import com.capg.service.BookServiceImpl;

@RestController
@RequestMapping("/Books")
public class BookController {
	@Autowired
	private BookServiceImpl bookService;

	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book Book) {
		Book lib = bookService.createBook(Book);
		return new ResponseEntity<Book>(lib, HttpStatus.CREATED);
	}

	@GetMapping("/viewById/{bookId}")
	public ResponseEntity<Book> viewBook(@PathVariable("bookId") int bookId) {
		Book lib = bookService.viewBookById(bookId);
		return new ResponseEntity<Book>(lib, HttpStatus.OK);
	}

	@GetMapping("/viewAllBook")
	public List<Book> viewAllBook() {
		return bookService.viewBook();
	}

	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {

		return bookService.updatebook(book);

	}

	@DeleteMapping("/deleteBook/{bookId}")
	public void removeBook(@PathVariable("bookId") int bookId) {
		bookService.removeBook(bookId);
	}

	@GetMapping("/viewByBookName/{bookName}")
	public ResponseEntity<?> viewByBookByName(@PathVariable("bookName") String bookName) {
		List<Book> books = bookService.viewByBookName(bookName);
		return ResponseEntity.ok(books);
	}

	@GetMapping("/viewByAuthorName/{bookAuthor}")
	public ResponseEntity<?> viewBookByAuthorName(@PathVariable("bookAuthor") String bookAuthor) {

		List<Book> books = bookService.viewByBookAuthor(bookAuthor);
		return ResponseEntity.ok(books);
	}

	@GetMapping("/viewByPublisherName/{bookPublisher}")
	public ResponseEntity<?> viewBookByPublisherName(@PathVariable("bookPublisher") String bookPublisher) {

		List<Book> books = bookService.viewByBookPublisher(bookPublisher);
		return ResponseEntity.ok(books);

	}

}
