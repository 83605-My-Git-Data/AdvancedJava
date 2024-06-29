package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.UserDto;
import com.sunbeam.dto.VehicleDto;
import com.sunbeam.entities.User;
import com.sunbeam.service.VehicleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	
	@Autowired
	VehicleService vehicleService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addVechile(@RequestBody VehicleDto vehicleDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addNewVehicle(vehicleDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponce(e.getMessage()));
		}
	}
	
	@GetMapping("/vehicles/{name}")
	public ResponseEntity<?> getVehiclesByName(@PathVariable String name){
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByName(name));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponce(e.getMessage()));
		}
	}
	
	@DeleteMapping("/vehicles/{name}")
	public ResponseEntity<?> deleteVehicleByName(@PathVariable String name){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(vehicleService.deleteByName(name));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponce(e.getMessage()));
		}
	}
	
	

}
