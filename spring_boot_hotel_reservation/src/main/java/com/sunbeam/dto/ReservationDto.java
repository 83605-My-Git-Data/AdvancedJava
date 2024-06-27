package com.sunbeam.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Room;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ReservationDto {
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long guestId;
	@JsonProperty(access = Access.WRITE_ONLY)
	private LocalDate checkInDate;
	@JsonProperty(access = Access.WRITE_ONLY)
	private LocalDate checkOutDate;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long roomId;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	


}
