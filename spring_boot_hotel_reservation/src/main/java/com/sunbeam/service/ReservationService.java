package com.sunbeam.service;

import com.sunbeam.dto.ApiResponce;
import com.sunbeam.dto.ReservationDto;

public interface ReservationService {
	ApiResponce makeReservation(ReservationDto reservationDto);
	ApiResponce deleteReservation(Long id);

}
