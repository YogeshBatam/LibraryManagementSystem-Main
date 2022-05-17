package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.models.ReturnBook;

import com.capg.service.ReturnBookService;

@RestController
@RequestMapping("/returnBook")
public class ReturnBookController {
	
	@Autowired
	private ReturnBookService returnService;

	@PostMapping("/create")
	public Object addReturnbook(@RequestBody ReturnBook returnBook) {

			ReturnBook lib = returnService.createReturnBook(returnBook);
			return ResponseEntity.ok(lib);
		
	}

	@GetMapping("/get/{returnbookid}")
	public ResponseEntity<?> viewBook(@PathVariable("returnbookid") int returnbookid) {
		

			return ResponseEntity.ok(returnService.viewReturnBookById(returnbookid));
		

	}

	@PutMapping("/updateBook")
	public ResponseEntity<?> updateBook(@RequestBody ReturnBook returnBook) {

		
			return ResponseEntity.ok(returnService.updateReturnbook(returnBook));
		
	}

	@DeleteMapping("/delete/{bookid}")
	public void deleteReturnbookById(@PathVariable int bookid) {
		
			returnService.removeReturnBook(bookid);
		}

	

}
