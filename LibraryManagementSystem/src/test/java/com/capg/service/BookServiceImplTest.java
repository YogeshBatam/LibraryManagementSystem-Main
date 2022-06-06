package com.capg.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.models.Book;
import com.capg.repository.IBookRepository;
@SpringBootTest
class BookServiceImplTest {
	@Autowired
	private BookServiceImpl service;
	
	@MockBean
	private IBookRepository repo;
	
	@BeforeEach
	void setup() throws Exception{
		Book book=Book.builder().isbn(1234).bookName("java")
				.bookAuthor("RK Sharma").bookPublisher("sunsystem")
				.student(null).build();
		List<Book>b=new ArrayList<Book>();
		b.add(book);
	Mockito.when(repo.getBookBybookName("java")).thenReturn(b);
	}
	@Test
	void testViewByBookName() {
			String bookName="java";
			List<Book> book=service.viewByBookName(bookName);
			for(Book b: book) {
				assertEquals(b.getBookName(),bookName);
			}
	}

}
