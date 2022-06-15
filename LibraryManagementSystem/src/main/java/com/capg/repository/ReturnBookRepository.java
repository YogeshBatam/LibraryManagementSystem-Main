package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.models.ReturnBook;

@Repository
public interface ReturnBookRepository extends JpaRepository<ReturnBook, Integer> {

}
