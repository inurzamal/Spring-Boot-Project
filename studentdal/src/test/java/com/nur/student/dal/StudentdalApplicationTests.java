package com.nur.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nur.student.dal.entities.Student;
import com.nur.student.dal.repo.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository repo;

	
	//Create Student
	
	@Test
	void testCreateStudent() {		
		Student student = new Student();		
		student.setName("Rahul");
		student.setCourse("Spring Boot");
		student.setFee(500d);		
		repo.save(student); 
	}
	
	//Read Student
	
	@Test
	void testFindStudentById() {
		Student student = repo.findById(1l).get(); 
		System.out.println(student);
	}
	
	//Update Student
	
	@Test
	void testUpdateStudent() {
		Student student = repo.findById(1l).get();
		student.setFee(700d);
		repo.save(student);
	}
	
	//Delete Student
	
//	@Test
//	void testDeleteStudent() {
//		repo.deleteById(1l);
//	}

}
