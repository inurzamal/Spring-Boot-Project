package com.nur.student.dal.repo;

import org.springframework.data.repository.CrudRepository;

import com.nur.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
