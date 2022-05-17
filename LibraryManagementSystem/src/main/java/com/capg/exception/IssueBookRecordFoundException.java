package com.capg.exception;

public class IssueBookRecordFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public IssueBookRecordFoundException(String msg) {
		super(msg);
	}

}
