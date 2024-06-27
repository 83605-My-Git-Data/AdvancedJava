package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class GuestDto extends BaseDto {
	private String firstName;
	private String lastName;
	private LocalDate dob;
	

}
