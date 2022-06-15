package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.models.Fine;
@Repository
public interface FineRepository extends JpaRepository<Fine, Integer> {

	

}
