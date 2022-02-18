package com.nur.student.dal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nur.student.dal.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("select case when count(s) >0 then true else false end from Student s where s.id=?1")
	Boolean isStudentExist(Long id);

}
