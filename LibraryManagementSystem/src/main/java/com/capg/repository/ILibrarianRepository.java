package com.capg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.models.Librarian;
@Repository
public interface ILibrarianRepository extends JpaRepository<Librarian, Integer> {

	Librarian findByLibrarianUsername(String adminUsername);

	Optional<Librarian> findByLibrarianUsernameAndLibrarianPassword(String librarianUsername, String librarianPassword);

}
