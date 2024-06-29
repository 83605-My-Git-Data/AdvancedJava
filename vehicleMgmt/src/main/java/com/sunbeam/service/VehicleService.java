package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.UserDto;
import com.sunbeam.dto.VehicleDto;
import com.sunbeam.entities.User;
import com.sunbeam.entities.Vehicle;

public interface VehicleService {
	ApiResponce addNewVehicle(VehicleDto vehicleDto);
	List<Vehicle> getVehiclesByName(String name);
	ApiResponce deleteByName(String name);
}
