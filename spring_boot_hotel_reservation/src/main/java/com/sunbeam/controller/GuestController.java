package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.GuestDto;
import com.sunbeam.service.GuestService;



@RestController
@RequestMapping("/guests")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	
	@PostMapping
	private ResponseEntity<?> addGuest(@RequestBody GuestDto guestDto){
		try {
			System.out.println("inside controller "+guestDto.toString());
		 return ResponseEntity.status(HttpStatus.CREATED).body(guestService.addGuest(guestDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponce(e.getMessage()));
		}
	}

}
