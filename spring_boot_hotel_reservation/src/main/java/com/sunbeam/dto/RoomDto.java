package com.sunbeam.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sunbeam.entities.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class RoomDto extends BaseDto {
	
	
	private double price;
	private int roomNo;
	private Type type;
	

	

}
