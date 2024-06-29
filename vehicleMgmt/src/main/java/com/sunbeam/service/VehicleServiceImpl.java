package com.sunbeam.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.VehicleDao;
import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.UserDto;

import com.sunbeam.dto.VehicleDto;
import com.sunbeam.entities.User;
import com.sunbeam.entities.Vehicle;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public ApiResponce addNewVehicle(VehicleDto vehicleDto) {
		
  User user= 	userDao.findById(vehicleDto.getUserId()).orElseThrow(() -> new RuntimeException("cannot find user with this id"));
	  Vehicle vehicle =   mapper.map(vehicleDto, Vehicle.class);
	  
	  vehicle.setUser(user);
	  
	 vehicleDao.save(vehicle);
	   return new ApiResponce("Vehicle added successfully to user");
	 
	 
		
	}

	@Override
	public List<Vehicle> getVehiclesByName(String name) {
		List<Vehicle> list = vehicleDao.findByUser_name(name);
		return list;
	}

	@Override
	public ApiResponce deleteByName(String name) {
		vehicleDao.deleteByUser_name(name);
		
		return new ApiResponce("deleted vehicle succesfully");
		
	}

	

	
	
	

	


	

}
