package com.capg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.capg.exception.FineNotFoundException;
import com.capg.exception.LibrarianNotFoundException;
import com.capg.exception.StudentNotFoundException;
import com.capg.models.Book;
import com.capg.models.Fine;
import com.capg.models.IssueBook;
import com.capg.models.Librarian;
import com.capg.models.ReturnBook;
import com.capg.models.Student;
import com.capg.service.BookServiceImpl;
import com.capg.service.BusinessLogic;
import com.capg.service.FineService;
import com.capg.service.IssueBookService;
import com.capg.service.LibrarianService;
import com.capg.service.ReturnBookService;
import com.capg.service.StudentServiceImpl;

@RestController
@RequestMapping("/librarian")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"},allowedHeaders = "*")
public class LibrarianController {
	
	private int validLibrarian = 0;
	
	int StudentId;
	@Autowired
	private LibrarianService librarianService;

	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private IssueBookService issueBookService;
	@Autowired
	private StudentServiceImpl studentService;
	@Autowired
	private FineService fineService;
	
	@Autowired
	private ReturnBookService returnService;
	
	
	@PostMapping("/login")
	//@CrossOrigin("http://localhost:4200")
	public boolean doLogin(@RequestBody Librarian lib,HttpServletRequest req)throws LibrarianNotFoundException
	{
		String username = lib.getLibrarianUsername();
		String password = lib.getLibrarianPassword();
		
		if(librarianService.validateLibrarian(username, password) == true)
		{
			validLibrarian = 1;
			Librarian librarian = librarianService.viewByLibrarianUserName(username, password).get();

				return true;
		}
		else
		{
			return false;
		}
	
	}

	@PostMapping("/addlibrarian")
	//@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Librarian> createLibrarian(@RequestBody Librarian librarian) {
		Librarian lib = librarianService.addLibrarian(librarian);
		return new ResponseEntity<Librarian>(lib, HttpStatus.CREATED);
	}

	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		if (validLibrarian == 1) {
			validLibrarian = 0;
			return ResponseEntity.ok("Logged out...");
		} else
			return ResponseEntity.ok("Not Logged In");
	}
	
	@PutMapping("/updatelibrarian")
	
	public ResponseEntity<Librarian> updateLibrarian(@RequestBody Librarian librarian) {
		Librarian lib = librarianService.updateLibrarian(librarian);
		return new ResponseEntity<Librarian>(lib, HttpStatus.OK);
	}
	
	public Boolean containsSequences(String uname, String pwd){
		 
		  Boolean b=pwd.contains(uname);
		  return b;
		}
	
	
	
	
	
	

// --------------Book Services------------------------------------------------------------
	@PostMapping("/createBook")
	public ResponseEntity<?> createBook(@RequestBody Book Book) {
		if (validLibrarian == 1) {
			
			return ResponseEntity.ok(bookService.createBook(Book));
		} else {
			return ResponseEntity.ok("Not Logged In");
		}
	}

	@GetMapping("/viewBookById/{bookId}")
	public ResponseEntity<?> viewBookById(@PathVariable("bookId") int bookId) {
		if (validLibrarian == 1) {
			Book lib = bookService.viewBookById(bookId);
			
			return ResponseEntity.ok(lib);
		} else {
			return ResponseEntity.ok("Not Logged In");
		}
	}

	@GetMapping("/viewAllBook")
	public ResponseEntity<?> viewAllBook() {
		if (validLibrarian == 1) {
			return ResponseEntity.ok(bookService.viewBook());
		} else {
			return ResponseEntity.ok("Not Logged In");
		}
	}

	@PutMapping("/updateBook")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		if (validLibrarian == 1) {
			return ResponseEntity.ok(bookService.updatebook(book));
		} else {
			return ResponseEntity.ok("Not Logged In");
		}
	}

	@DeleteMapping("/deleteBook/{bookId}")
	public void removeBook(@PathVariable("bookId") int bookId) {
		if (validLibrarian == 1) {
			bookService.removeBook(bookId);
		}
	}
	
	@GetMapping("/viewByBookName/{bookName}")
	public ResponseEntity<?> viewByBookByName(@PathVariable("bookName") String bookName) {
		if (validLibrarian== 1) {
			List<Book> books = bookService.viewByBookName(bookName);
			return ResponseEntity.ok(books);
		} else {
			return ResponseEntity.ok("Not Logged In");
		}
	}
	
	@GetMapping("/viewByAuthorName/{bookAuthor}")
	public ResponseEntity<?> viewBookByAuhtorName(@PathVariable("bookAuthor") String bookAuthor) {
		if (validLibrarian== 1) {
			List<Book> books = bookService.viewByBookAuthor(bookAuthor);
			return ResponseEntity.ok(books);
		} else {
			return ResponseEntity.ok("Not Logged In");
		}
	}
	
	@GetMapping("/viewByPublisherName/{bookPublisher}")
	public ResponseEntity<?> viewBookByPublisherName(@PathVariable("bookPublisher") String bookPublisher) {
		if (validLibrarian== 1) {
		List<Book> books = bookService.viewByBookPublisher(bookPublisher);
		return ResponseEntity.ok(books);
		}else {
			return ResponseEntity.ok("Not Logged In");
		}

	}
	
//------------------------Student Services------------------------------------------------
	

	@GetMapping("/viewStudentById/{StudentId}")
	public ResponseEntity<?>  getStudent(@PathVariable("StudentId") int  studentId) throws StudentNotFoundException
	{if (validLibrarian == 1) {
		Student stu = studentService.viewStudentById(studentId);
	    return ResponseEntity.ok(stu);
	}else {
		return ResponseEntity.ok("Not Logged in");
	}
	}
	
	
	@GetMapping("/allStudent")
	public ResponseEntity<?> getAllStudent() 
	{if (validLibrarian == 1) {
	return ResponseEntity.ok(studentService.viewAllStudent());
	}
	else {
		return ResponseEntity.ok("Not Logged in");
	}
	}
	
//-------------------Issue Book------------------------------------------------------------------
	@PostMapping(value = "/createIssueBook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createIssueBook(@RequestBody IssueBook issueBook) throws Exception {
		if (validLibrarian == 1) {
			
		Book book=bookService.viewBookById(issueBook.getBookId());
		if(book.getStatus().equalsIgnoreCase("Available")) {
		book.setStatus("Issued");
		bookService.updatebook(book);
		
		Student st=studentService.viewStudentById(issueBook.getStudentId());
		st.getIssueBook().add(book);	
		studentService.updateStudent(st);
		IssueBook bi = issueBookService.createIssueBook(issueBook);	
		return ResponseEntity.ok(bi);
		}
		else {
			return ResponseEntity.ok("Book Not available");
			
		}
		}else {
			return ResponseEntity.ok("Not Logged in");
		}
	}

	@GetMapping("/viewByIssueId/{bookIssueId}")
	public ResponseEntity<?> viewIssueBook(@PathVariable("bookIssueId") int bookIssueId){
		if (validLibrarian == 1) {
		IssueBook bi = issueBookService.viewIssueBookById(bookIssueId);
		return  ResponseEntity.ok(bi);
		}
		else {
			return ResponseEntity.ok("Not Logged in");
		}
	}

	@GetMapping("/viewAllIssueBook")
	public ResponseEntity<?> viewAllIssueBook() {
		if (validLibrarian == 1) {
		return ResponseEntity.ok(issueBookService.viewIssueBook());
		}
		else {
			return ResponseEntity.ok("Not Logged in");
		}
	}

	@PutMapping("/updateIssueBook")
	public ResponseEntity<?> updateIssueBook(@RequestBody IssueBook bookIssue)  {
		if (validLibrarian == 1) {
		return ResponseEntity.ok(issueBookService.updatebookIssue(bookIssue));
		}
		else {
			return ResponseEntity.ok("Not Logged in");
		}

	}

	@DeleteMapping("/deleteIssueBook/{bookIssueId}")
	public void removeIssueBook(@PathVariable("bookIssueId") int bookIssueId)  {
		
		issueBookService.removeIssueBook(bookIssueId);
	}
	
	
//---------------------------ReturnBook---------------------------------------
	

	@PostMapping("/createReturnBook")
	public ResponseEntity<?> addReturnbook(@RequestBody ReturnBook returnBook) throws StudentNotFoundException {

		if (validLibrarian == 1) {
			
			ReturnBook lib = returnService.createReturnBook(returnBook);
			Book book=bookService.viewBookById(returnBook.getBookId());
			book.setStatus("Available");
			bookService.updatebook(book);
			
			Student st=studentService.viewStudentById(returnBook.getStudentId());
			if(st.getIssueBook().contains(book)) {
				st.getIssueBook().remove(book);
			}
			studentService.updateStudent(st);
			
			IssueBook ib=issueBookService.viewIssueBookById(returnBook.getIssuedId());
			ib.setReturnId(returnBook.getReturnId());
			ib.setReturnedStatus("Returned");
			issueBookService.updatebookIssue(ib);
//			
			
			return ResponseEntity.ok(lib);
		} else {
			return ResponseEntity.ok("Not Logged In");
		}
	}

	@GetMapping("/get/{returnbookid}")
	public ResponseEntity<?> viewReturnBook(@PathVariable("returnbookid") int returnbookid) {
		if (validLibrarian == 1) {

			return ResponseEntity.ok(returnService.viewReturnBookById(returnbookid));
		} else {
			return ResponseEntity.ok("Not Logged In");
		}

	}

	@PutMapping("/updateReturnBook")
	public ResponseEntity<?> updateReturnBook(@RequestBody ReturnBook returnBook) {

		if (validLibrarian == 1) {
			return ResponseEntity.ok(returnService.updateReturnbook(returnBook));
		} else {
			return ResponseEntity.ok("Not Logged In");
		}
	}

	@DeleteMapping("/delete/{returnbookid}")
	public void deleteReturnbookById(@PathVariable int returnbookid) {
		if (validLibrarian == 1) {
			returnService.removeReturnBook(returnbookid);
		}
	}
	@GetMapping("/viewAllReturnBook")
	public ResponseEntity<?> viewAllReturnBook() {
		List<ReturnBook> rb=returnService.viewReturnBook();
		return ResponseEntity.ok(rb);
	}
	
//----------------------Fine---------------------------------------------------------
	
	@Autowired
	private BusinessLogic logic;
	@PostMapping("/createFine")
	public ResponseEntity<?>createFine(@RequestBody Fine fine){
		if(validLibrarian==1) {
			fine.setFineamount(logic.getFine(fine.getNoOfDelayDays()));
			return fineService.createFine(fine);	
		}
		else {
			return ResponseEntity.ok("Noy Logged in");
		}
	}
	
	@GetMapping("/fine")  
	public ResponseEntity<?> getAllFine()   
	{  if (validLibrarian == 1) {
	return ResponseEntity.ok(fineService.getAllFine());  
	}  else {
		return ResponseEntity.ok("Noy Logged in");
	}
	}
	  
	@GetMapping("/getfine/{fineid}")  
	public ResponseEntity< ?> getFine(@PathVariable("fineid") int fineid) throws FineNotFoundException   
	{  
		if(validLibrarian == 1) {
		
		 return fineService.getFineById(fineid);  
		}else {
			return ResponseEntity.ok("Not Logged in");
		}
	  
	}  
	  
	@DeleteMapping("/fine/{fineid}")  
	public void deleteFine(@PathVariable("fineid") int fineid)   
	{  
		if(validLibrarian == 1) {
	fineService.deleteFineById(fineid);  
	} 
	}
	@PutMapping("/upadatefine")  
   public ResponseEntity<?> updatefine(@RequestBody Fine fine)   
	{  
		if (validLibrarian == 1) {
			fine.setFineamount(logic.getFine(fine.getNoOfDelayDays()));
			return ResponseEntity.ok(fineService.updateFine(fine));
		}
		else {
			return ResponseEntity.ok("Not Logged in");
		}
	  
	}
	
}
