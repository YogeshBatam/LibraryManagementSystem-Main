package com.capg.service;

import java.util.List;

import com.capg.models.IssueBook;

public interface IIssueBookService {
	IssueBook createIssueBook(IssueBook bookIssue);

	IssueBook viewIssueBookById(int bookIssueId) ;

	List<IssueBook> viewIssueBook();

	IssueBook updatebookIssue(IssueBook bookIssue) ;

	void removeIssueBook(int bookIssueId) ;
}
