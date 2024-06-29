package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiRespoce;
import com.sunbeam.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getStudentsByName(@PathVariable String name) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsForCourse(name));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespoce(e.getMessage()));
		}
	}
	
	
	

}
