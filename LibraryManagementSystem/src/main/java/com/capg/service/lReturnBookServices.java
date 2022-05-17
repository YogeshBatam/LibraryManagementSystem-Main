package com.capg.service;

import java.util.List;

import com.capg.models.ReturnBook;

public interface lReturnBookServices {

	ReturnBook createReturnBook(ReturnBook returnbook);

	ReturnBook viewReturnBookById(int returnbookId);

	List<ReturnBook> viewReturnBook();

	ReturnBook updateReturnbook(ReturnBook returnbook);

	void removeReturnBook(int returnbookId);

}
