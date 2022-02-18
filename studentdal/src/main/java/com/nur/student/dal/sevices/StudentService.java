package com.nur.student.dal.sevices;

import java.util.List;

import com.nur.student.dal.entities.Student;

public interface StudentService {
	 
	
	public List<Student> findAllStudent();
	
	public Student getStudentById(Long id);

}
