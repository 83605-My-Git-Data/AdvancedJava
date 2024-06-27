package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.RoomDto;
import com.sunbeam.entities.Room;


@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public ApiResponce addRoom(RoomDto roomDto) {
		
		Room room =   mapper.map(roomDto, Room.class);
		room.setAvailability(true);
		
	 Room persistentRoom = 	roomDao.save(room);
	 
	 return new ApiResponce("New Room added with id"+persistentRoom.getId());
		
	}
	
	
	public List<Room> findAvailableRoom(LocalDate date) {
		
	 List<Room> bookedRoom = 	reservationDao.findReservationsOnDate(date);
	  		List<Room> rooms =  roomDao.findAll();
	  		
	  		rooms.removeAll(bookedRoom);
	  		
	  		return rooms;
		
	}
	
	

}
