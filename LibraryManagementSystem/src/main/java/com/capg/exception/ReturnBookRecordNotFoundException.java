package com.capg.exception;

public class ReturnBookRecordNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ReturnBookRecordNotFoundException(String msg) {
		super(msg);
	}

}
