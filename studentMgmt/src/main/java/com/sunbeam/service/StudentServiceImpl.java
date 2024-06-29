package com.sunbeam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.StudentDao;
import com.sunbeam.entities.Student;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getStudentsForCourse(String name) {
		List<Student> list=  studentDao.findByCourse_name(name);
		
		return list;
	}

}
