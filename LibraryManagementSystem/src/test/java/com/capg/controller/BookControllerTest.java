package com.capg.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capg.models.Book;
import com.capg.service.BookServiceImpl;
@WebMvcTest(controllers = BookController.class)
class BookControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private BookServiceImpl service;
	
	private Book book;
	
	@BeforeEach
	void setup() throws Exception{
		
		@SuppressWarnings("unused")
		Book book=Book.builder().bookId(1).isbn(1234).bookName("java")
				.bookAuthor("RK Sharma").bookPublisher("sunsystem")
				.student(null).build();
	}
	@Test
	void testUpdateBooks() throws Exception{
		Book book2=Book.builder().bookId(1).isbn(1235).bookName("java")
				.bookAuthor("RK Sharma").bookPublisher("sunsystem")
				.student(null).build();

		Mockito.when(service.updatebook(book2)).thenReturn(book);
		
		mvc.perform(MockMvcRequestBuilders.put("/updateBook").contentType(MediaType.APPLICATION_JSON).content("{\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	
			
		
	}
}


