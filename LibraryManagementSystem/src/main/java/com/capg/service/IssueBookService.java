package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.exception.IssueBookRecordNotFoundException;
import com.capg.models.IssueBook;
import com.capg.repository.IIssueBookRepository;
@Service
public class IssueBookService implements IIssueBookService {

	@Autowired
	private IIssueBookRepository repository;

	@Override
	public IssueBook createIssueBook(IssueBook bookIssue) {
		return repository.save(bookIssue);
	}

	@Override
	public IssueBook viewIssueBookById(int bookIssueId) {
		if (repository.findById(bookIssueId).isPresent()) {
			return repository.findById(bookIssueId).get();
		} else {
			throw new IssueBookRecordNotFoundException("IssueBook with id " + bookIssueId + " does not exist");
		}
	}

	@Override
	public List<IssueBook> viewIssueBook() {
		List<IssueBook> bookIssues = new ArrayList<IssueBook>();
		repository.findAll().forEach(ib1 -> bookIssues.add(ib1));
		return bookIssues;
	}

	@Override
	public IssueBook updatebookIssue(IssueBook issueBook)  {
		if (repository.findById(issueBook.getIssueId()).isPresent()) {
			return repository.save(issueBook);
		} else {
			throw new IssueBookRecordNotFoundException("IssueBook with id " + issueBook.getIssueId() + " does not exist");
		}
	}

	@Override
	public void removeIssueBook(int bookIssueId) {
		if (repository.findById(bookIssueId).isPresent()) {
			repository.deleteById(bookIssueId);
		} else {
			throw new IssueBookRecordNotFoundException("IssueBook with id " + bookIssueId + " does not exist");
		}
	}

}
