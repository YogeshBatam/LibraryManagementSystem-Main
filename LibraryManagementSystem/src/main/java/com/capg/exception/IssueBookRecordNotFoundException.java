package com.capg.exception;

public class IssueBookRecordNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public IssueBookRecordNotFoundException(String msg) {
		super(msg);
	}

}
