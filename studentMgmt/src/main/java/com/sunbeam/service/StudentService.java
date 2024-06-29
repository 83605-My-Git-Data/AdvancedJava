package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.Student;

public interface StudentService {
	
	List<Student> getStudentsForCourse(String name);
}
