package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponce {
	
	private String message;
	private LocalDate timeStamp;
	
	public ApiResponce(String message) {
		super();
		this.message = message;
		this.timeStamp = LocalDate.now();
	}
	

}
