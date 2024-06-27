package com.sunbeam.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.GuestDao;
import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.GuestDto;
import com.sunbeam.entities.Guest;


@Service
@Transactional
public class GuestServiceImpl  implements GuestService{
	
	@Autowired
	private GuestDao guestDao;
	
	@Autowired
	private ModelMapper mapper;
	
	

	@Override
	public ApiResponce addGuest(GuestDto guestDto) {
		Guest guest =  mapper.map(guestDto, Guest.class);
		
	 Guest persistentGuest =  	guestDao.save(guest);
	 
	 
		
		return new ApiResponce("New guest added with id: "+persistentGuest.getId());
	}

}
