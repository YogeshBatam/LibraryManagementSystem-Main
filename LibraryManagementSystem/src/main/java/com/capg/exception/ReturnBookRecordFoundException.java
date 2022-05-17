package com.capg.exception;

public class ReturnBookRecordFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ReturnBookRecordFoundException(String msg) {
		super(msg);
	}

}
