package com.capg.service;

import java.util.Optional;

import com.capg.models.Librarian;

public interface ILibrarianService {
	public Librarian addLibrarian(Librarian librarian);
	
	public boolean validateLibrarian(String username, String password);
	
	public Optional<Librarian> viewByLibrarianUserName(String username, String password);
}
