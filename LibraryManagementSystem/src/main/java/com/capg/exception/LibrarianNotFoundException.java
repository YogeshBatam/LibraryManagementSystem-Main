package com.capg.exception;

public class LibrarianNotFoundException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public LibrarianNotFoundException(String message) {
		super(message);
	}
}
