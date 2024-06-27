package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.ReservationDto;
import com.sunbeam.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	
	
	@Autowired
	ReservationService reservationService;

	
	@PostMapping
	public ResponseEntity<?>bookRoom(@RequestBody ReservationDto reservationDto){
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservationService.makeReservation(reservationDto));
		}
		catch (Exception e) {
		return	ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponce(e.getMessage()));
		}
	}
	
	
	@DeleteMapping("/{reservationId}")
	public ResponseEntity<?> cancelReservation(@PathVariable Long reservationId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(reservationService.deleteReservation(reservationId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponce(e.getMessage()));
		}
	}
	
	
}
