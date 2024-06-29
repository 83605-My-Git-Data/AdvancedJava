package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Student;
import java.util.List;


public interface StudentDao extends JpaRepository<Student, Long> {
	List<Student> findByCourse_name(String name);

}
