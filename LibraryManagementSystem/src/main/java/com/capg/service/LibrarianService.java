package com.capg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.exception.LibrarianFoundException;
import com.capg.exception.LibrarianNotFoundException;
import com.capg.models.Librarian;
import com.capg.repository.ILibrarianRepository;
@Service
public class LibrarianService implements ILibrarianService {

	@Autowired
	private ILibrarianRepository Librarianrepo;

	@Override
	public Librarian addLibrarian(Librarian librarian) {
		Librarian obj = Librarianrepo.findByLibrarianUsername(librarian.getLibrarianUsername());
		if(obj != null)
			throw new LibrarianFoundException("Librarian already created");
		return Librarianrepo.save(librarian);
	}

	@Override
	public boolean validateLibrarian(String username, String password) {
		Optional<Librarian> Librarian = Librarianrepo.findByLibrarianUsernameAndLibrarianPassword(username, password);
		if(Librarian.get() == null)
			throw new LibrarianNotFoundException("Librarian not created");
		else
			return true;
	}

	@Override
	public Optional<Librarian> viewByLibrarianUserName(String username, String password) {
		Optional<Librarian> Librarian = Librarianrepo.findByLibrarianUsernameAndLibrarianPassword(username, password);
		if(Librarian.get() == null)
			throw new LibrarianNotFoundException("Librarian not created");
		return Librarian;		
	}

}


