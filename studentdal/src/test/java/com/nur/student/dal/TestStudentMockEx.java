package com.nur.student.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.nur.student.dal.entities.Student;
import com.nur.student.dal.repo.StudentRepository;
import com.nur.student.dal.sevices.StudentServiceImpl;

@SpringBootTest
public class TestStudentMockEx {
	
	@Mock
	StudentRepository studentRepository;
	
	@InjectMocks
	StudentServiceImpl studentService;
	
	@Test
	void testFindAllStudent(){
		
		Student s1 = new Student();
		s1.setId(123l);
		s1.setName("Rahul");
		s1.setCourse("Java");
		s1.setFee(50d);
	
		List<Student> myList = List.of(s1);
		
		when(studentRepository.findAll()).thenReturn(myList);
		List<Student> actualAllStudent = studentService.findAllStudent();
		
		assertNotNull(actualAllStudent);
		assertEquals(myList, actualAllStudent);
		verify(studentRepository).findAll();
		
//		System.out.println(myList);
//		System.out.println(actualAllStudent);
		
	}

}
