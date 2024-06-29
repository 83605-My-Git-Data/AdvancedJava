package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Course;
import java.util.List;


public interface CourseDao extends JpaRepository<Course, Long> {
	List<Course> findByName(String name);
	
	
	

}
