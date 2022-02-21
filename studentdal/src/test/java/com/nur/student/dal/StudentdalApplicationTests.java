package com.nur.student.dal;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nur.student.dal.entities.Student;
import com.nur.student.dal.repo.StudentRepository;
import com.nur.student.dal.sevices.StudentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository repo;
	
	@MockBean
	private StudentService service;

	
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
		student.setFee(600d);
		repo.save(student);
	}
	
	//Delete Student
	
//	@Test
//	void testDeleteStudent() {
//		repo.deleteById(2l);
//	}
	
	@Test
	void isStudentExist() {		
		Boolean actualResult = repo.isStudentExist(3l);		
		boolean expectedResult = true;		
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
