package com.sunbeam.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.sunbeam.dao.CourseDao;
import com.sunbeam.dto.ApiRespoce;
import com.sunbeam.dto.CourseDto;
import com.sunbeam.entities.Course;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public ApiRespoce addCourse(CourseDto courseDto) {
		Course course =  mapper.map(courseDto, Course.class);
		
		courseDao.save(course);
		
		return new ApiRespoce("course added successfully");
		
	}

	@Override
	public ApiRespoce updateCourse(Long id, Course course) {
	 Course existingCourse = 	courseDao.findById(id).orElseThrow(()-> new RuntimeException("wrong course id"));
	 
	 
//	  Course mappedCourse = mapper.map(course, Course.class); //no need of mapping
	 existingCourse.setStartDate(course.getStartDate());
	 existingCourse.setEndDate(course.getEndDate());
	 existingCourse.setFees(course.getFees());
	 
	 return new ApiRespoce("Updated course successfully");
	 
	 
	}

	@Override
	public List<Course> getCourseByName(String name) {
		  List<Course> list =   courseDao.findByName(name);
		  
		  return list;
	}

}
