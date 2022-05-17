package com.capg.exception;

public class BookFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BookFoundException(String message) {
		super(message);
	}

}
