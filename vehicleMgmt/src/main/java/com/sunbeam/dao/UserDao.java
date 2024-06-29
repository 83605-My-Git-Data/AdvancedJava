package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.dto.ApiResponce;
import com.sunbeam.entities.User;
import java.util.List;


public interface UserDao extends JpaRepository<User, Long>{
	
	List<User> findByName(String name);
	
	

}
