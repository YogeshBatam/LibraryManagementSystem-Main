package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.exception.IssueBookRecordNotFoundException;
import com.capg.models.ReturnBook;
import com.capg.repository.ReturnBookRepository;

@Service
public class ReturnBookService implements lReturnBookServices {
	@Autowired
	private ReturnBookRepository repository;

	@Override
	public ReturnBook createReturnBook(ReturnBook bookIssue) {
		return repository.save(bookIssue);
	}

	public ReturnBook viewReturnBookById(int ReturnbookId) {
		if (repository.findById(ReturnbookId).isPresent()) {
			return repository.findById(ReturnbookId).get();
		} else {
			throw new IssueBookRecordNotFoundException("BookIssue with id " + ReturnbookId + " does not exist");
		}
	}

	@Override
	public List<ReturnBook> viewReturnBook() {
		List<ReturnBook> bookIssues = new ArrayList<ReturnBook>();
		repository.findAll().forEach(ib1 -> bookIssues.add(ib1));
		return bookIssues;
	}

	@Override
	public ReturnBook updateReturnbook(ReturnBook returnbook) {
		{
			return repository.save(returnbook);
		}

	}

	@Override
	public void removeReturnBook(int ReturnbookId) {
		if (repository.findById(ReturnbookId).isPresent()) {
			repository.deleteById(ReturnbookId);
		} else {
			throw new IssueBookRecordNotFoundException("BookIssue with id " + ReturnbookId + " does not exist");
		}
	}
}
