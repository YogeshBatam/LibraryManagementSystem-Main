package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.exception.StudentNotFoundException;
import com.capg.models.Student;
import com.capg.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private IStudentRepository repository;

	@Override
	public Student createStudent(Student student) {
		return repository.save(student) ;
	}

	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException {
		if(repository.findById(student.getStudentId()).isPresent()) {
			return repository.save(student);
		}
		else {
			throw new StudentNotFoundException("Student with Id "+student.getStudentId()+" does not exist");
		}
	}

	@Override
	public void removeStudent(int studentId) throws StudentNotFoundException {
		if(repository.findById(studentId).isPresent()) {
			repository.deleteById(studentId);
		}
		else {
			throw new StudentNotFoundException("Student with Id "+studentId+" does not exist");
		}
		
	}

	@Override
	public Student viewStudentById(int studentId) throws StudentNotFoundException {
		if(repository.findById(studentId).isPresent()) {
			return repository.findById(studentId).get();
		}
		else {
			throw new StudentNotFoundException("Student with Id "+studentId+" does not exist");
			
		}
	}

	@Override
	public List<Student> viewAllStudent() {
		List<Student> students=new ArrayList<Student>();
		repository.findAll().forEach(s1 -> students.add(s1));
		return students;
	}
	@Override
	public Student viewByLastName(String lastName) throws StudentNotFoundException {
		Student stu= repository.findBylastname(lastName);
		if(stu==null) {
			throw new StudentNotFoundException("Student with Name "+lastName+" does not exist");
		}
		return stu;
	}

	@Override
	public boolean validateStudent(String username, String password) throws StudentNotFoundException  {
		Optional<Student> student= repository.findByUserNameAndPassword(username, password);
		if(student.get() == null)
			throw new StudentNotFoundException("Student not created");
			
		else
			return true;
	}

	public Optional<Student> viewByUserName(String username, String password)throws StudentNotFoundException {
		Optional<Student> student= repository.findByUserNameAndPassword(username, password);
		if(student.get()== null)
			throw new StudentNotFoundException("Student not created");
		return student;		
	}
	
	
	
	
	
	
		
}
