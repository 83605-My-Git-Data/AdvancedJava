package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.RoomDto;
import com.sunbeam.entities.Room;

public interface RoomService {
	ApiResponce addRoom(RoomDto roomDto);
	List<Room> findAvailableRoom(LocalDate date);

}
