package com.sunbeam.service;

import java.time.LocalDate;
import java.util.Date;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.ReservationDto;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationDao reservationDao;
	
	
	@Autowired
	GuestDao guestDao;
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public ApiResponce makeReservation(ReservationDto reservationDto) {
		

		String message = "Sorry , room is not available for this date";
		
    Guest guest= guestDao.findById(reservationDto.getGuestId()).orElseThrow(()-> new        	RuntimeException("Invalid Guest"));

Room room = roomDao.findById(reservationDto.getRoomId()).orElseThrow(()-> new RuntimeException("Room not found"));

	if(room.getAvailability() == true) {

			Reservation reservation = 	mapper.map(reservationDto, Reservation.class);
			
			
			reservation.setGuest(guest);
			reservation.setRoom(room);
			
	reservation.setPrice(  reservationDto.getCheckOutDate().compareTo(reservationDto.getCheckInDate()) * room.getPrice());


			
			reservationDao.save(reservation);
			room.setAvailability(false);
			message = "Room booked successfully";
	return new ApiResponce(message);
	}
	return new ApiResponce(message);
	
	
	}
	
	
	public ApiResponce deleteReservation(Long id) {
		String message  = "Could not cancel reservation,provide proper id";
		
		Reservation reservation=   reservationDao.findById(id).orElseThrow(()-> new RuntimeException("Reservation not found"));
		

		reservation.getRoom().setAvailability(true);
		reservationDao.delete(reservation);
		message = "Succesfully cancelled reserevation";
		
		return new ApiResponce(message);
	}


	

}
