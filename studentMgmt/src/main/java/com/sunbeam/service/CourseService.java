package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiRespoce;
import com.sunbeam.dto.CourseDto;
import com.sunbeam.entities.Course;

public interface CourseService {
	ApiRespoce addCourse(CourseDto courseDto);
	ApiRespoce updateCourse(Long id, Course course);
	List<Course> getCourseByName(String name);

}
