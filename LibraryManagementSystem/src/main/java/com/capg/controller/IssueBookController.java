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

import com.capg.exception.IssueBookRecordNotFoundException;
import com.capg.models.IssueBook;
import com.capg.service.IssueBookService;

@RestController
@RequestMapping("/issuebook")
public class IssueBookController {
	

		@Autowired
		private IssueBookService service;

		@PostMapping("/createIssueBook")
		public ResponseEntity<IssueBook> createIssueBook(@RequestBody IssueBook bookIssue) {
			IssueBook bi = service.createIssueBook(bookIssue);
			return new ResponseEntity<IssueBook>(bi, HttpStatus.CREATED);
		}

		@GetMapping("/viewById/{bookIssueId}")
		public ResponseEntity<IssueBook> viewIssueBook(@PathVariable("bookIssueId") int bookIssueId)
				throws IssueBookRecordNotFoundException {

			IssueBook bi = service.viewIssueBookById(bookIssueId);
			return new ResponseEntity<IssueBook>(bi, HttpStatus.OK);
		}

		@GetMapping("/viewAllIssueBook")
		public List<IssueBook> viewAllIssueBook() {
			return service.viewIssueBook();
		}

		@PutMapping("/updateIssueBook")
		public IssueBook updateIssueBook(@RequestBody IssueBook bookIssue)  {

			return service.updatebookIssue(bookIssue);

		}

		@DeleteMapping("/deleteIssueBook/{bookIssueId}")
		public void removeIssueBook(@PathVariable("bookIssueId") int bookIssueId)  {
			service.removeIssueBook(bookIssueId);
		}
}
