package com.nur.student.dal.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nur.student.dal.entities.Student;
import com.nur.student.dal.repo.StudentRepository;

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

}
