package com.sunbeam.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiRespoce;
import com.sunbeam.dto.CourseDto;
import com.sunbeam.entities.Course;
import com.sunbeam.service.CourseService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/course")
@Validated
public class CourseController {
	
	@Autowired
	
	CourseService courseService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addNewCourse(@RequestBody @Valid CourseDto courseDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(courseDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespoce(e.getMessage()));
		}
	}
	
	//update start d end d and fee
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable @NotNull Long id, @RequestBody Course course) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(id, course));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespoce(e.getMessage()));
		}
		
		
	}
	
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getCourseByName (@PathVariable String name) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourseByName(name));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespoce(e.getMessage()));
		}
	}
	
	
	
	

	
	

}
