package com.sunbeam.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ApiResponce {
	private String message;
	private LocalDateTime timeStamp;
	
	public ApiResponce(String message) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}

}
