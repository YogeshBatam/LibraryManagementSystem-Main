package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.StudentNotFoundException;
import com.capg.models.Book;
import com.capg.models.Student;
import com.capg.service.BookServiceImpl;
import com.capg.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"},allowedHeaders = "*")

public class StudentController {
	private int validStudent = 0;

	private String welcome = "Welcome \n........................\n Student Id : ";

	@Autowired
	private StudentServiceImpl service;
	@Autowired
	private BookServiceImpl bookService;

//	@Autowired
//	private BookServiceImpl bookService;

	@PostMapping("/createStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student stu = service.createStudent(student);
		return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
	}

	@GetMapping("/login/{userName}/{password}")
	public ResponseEntity<?> validateStudent(@PathVariable("userName") String userName,
			@PathVariable("password") String password) throws StudentNotFoundException {
		boolean value = service.validateStudent(userName, password);
		if (value == true) {
			validStudent = 1;
			Student student = service.viewByUserName(userName, password).get();

			return ResponseEntity.ok(welcome + student.getStudentId() + "\n First Name : " + student.getFirstName()
					+ "\n Last Name : " + student.getLastname() + "\n Email : " + student.getEmailId()
					+ "\n Contact No : " + student.getContactNo());
		} else
			return ResponseEntity.ok("Invalid Credentials");
	}

	@PutMapping("/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) throws StudentNotFoundException {
		if (validStudent == 1) {
			return ResponseEntity.ok(service.updateStudent(student));
		} else
			return ResponseEntity.ok("Invalid Credentials");
	}

	@DeleteMapping("/deleteStudent/{StudentId}")
	public void removeStudent(@PathVariable("StudentId") int studentId) throws StudentNotFoundException {
	//	if (validStudent == 1) {
			service.removeStudent(studentId);
	//	} else
	//		System.out.println("not logged in");
	}

	@GetMapping("/allStudent")
	public ResponseEntity<?> getAllStudent() {
	//	if (validStudent == 1) {
			return ResponseEntity.ok(service.viewAllStudent());
	//	} else
		//	return ResponseEntity.ok("Invalid Credentials");
	}

	@GetMapping("/viewStudentById/{StudentId}")
	public ResponseEntity<?> viewStudent(@PathVariable("StudentId") int studentId)
			throws StudentNotFoundException {
	//	if (validStudent == 1) {
		Student stu = service.viewStudentById(studentId);
		return ResponseEntity.ok(stu);
		//}else
		//	return ResponseEntity.ok("not logged in");
	}

	@GetMapping("/viewStudentByLastName/{lastname}")
	public ResponseEntity<?> getBylastName(@PathVariable("lastname") String lastname)
			throws StudentNotFoundException {
		if (validStudent == 1) {
		Student stu = service.viewByLastName(lastname);
		return  ResponseEntity.ok(stu);
		}else
			return ResponseEntity.ok("not logged in");
	}

	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		if (validStudent == 1) {
			validStudent = 0;
			return ResponseEntity.ok("Logged out...");
		} else
			return ResponseEntity.ok("Not Logged In");
	}

	// --------------Book
	// Services------------------------------------------------------------

		@GetMapping("/viewAllBook")
		public ResponseEntity<?> viewAllBook() {
			if (validStudent == 1) {
				return ResponseEntity.ok(bookService.viewBook());
			} else {
				return ResponseEntity.ok("Not Logged In");
			}
		}

		@GetMapping("/viewById/{bookId}")
		public ResponseEntity<?> viewBook(@PathVariable("bookId") int bookId) {
			if (validStudent== 1) {
				Book lib = bookService.viewBookById(bookId);
				return ResponseEntity.ok(lib);
			} else {
				return ResponseEntity.ok("Not Logged In");
			}
		}
		
		@GetMapping("/viewByBookName/{bookName}")
		public ResponseEntity<?> viewByBookName(@PathVariable("bookName") String bookName) {
			if (validStudent== 1) {
				List<Book> lib = bookService.viewByBookName(bookName);
				return ResponseEntity.ok(lib);
			} else {
				return ResponseEntity.ok("Not Logged In");
			}
		}
		
		@GetMapping("/viewByAuhtorName/{bookAuthor}")
		public ResponseEntity<?> viewByAuhtorName(@PathVariable("bookAuthor") String bookAuthor) {
			if (validStudent== 1) {
				List<Book> lib = bookService.viewByBookAuthor(bookAuthor);
				return ResponseEntity.ok(lib);
			} else {
				return ResponseEntity.ok("Not Logged In");
			}
		}
		
		@GetMapping("/viewByPublisherName/{bookPublisher}")
		public ResponseEntity<?> viewByPublisherName(@PathVariable("bookPublisher") String bookPublisher) {
			if (validStudent== 1) {
				List<Book> lib = bookService. viewByBookPublisher(bookPublisher);
				return ResponseEntity.ok(lib);
			} else {
				return ResponseEntity.ok("Not Logged In");
			}
		}

	

	

}
