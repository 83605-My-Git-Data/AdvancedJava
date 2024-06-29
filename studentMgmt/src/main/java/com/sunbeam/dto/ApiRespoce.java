package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ApiRespoce {

	public ApiRespoce(String message) {
		super();
		this.message = message;
		this.timestamp = LocalDate.now();
	}
	private String message;
	private LocalDate timestamp;
	
	
}
