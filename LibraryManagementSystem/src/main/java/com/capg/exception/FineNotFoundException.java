package com.capg.exception;

public class FineNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public FineNotFoundException(String s) {
		super(s);
	}

}
