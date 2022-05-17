package com.capg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.models.Student;


@Repository
public interface IStudentRepository extends CrudRepository<Student, Integer>  {
//Student viewStudentBylastName(String lastName);
//	
//	List<Student> findByUserNameAndPassword(String userName, String password);	
	//Student viewStudentBylastName(String lastName);
//	
//	List<Student> findByUserNameAndPassword(String userName, String password);	
	 Student findBylastname(String lastname);
		
//		Optional<Student> findByUserNameAndPassword(String userName, String password);	

		Student findByuserName(String userName);

		Optional<Student> findByUserNameAndPassword(String userName, String password);	

}


