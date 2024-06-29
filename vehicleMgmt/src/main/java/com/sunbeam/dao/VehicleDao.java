package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.User;
import com.sunbeam.entities.Vehicle;
import java.util.List;

import javax.transaction.Transactional;


public interface VehicleDao  extends JpaRepository<Vehicle, Long>{
	List<Vehicle> findByUser_name(String name);
	void deleteByUser_name(String name);
}
