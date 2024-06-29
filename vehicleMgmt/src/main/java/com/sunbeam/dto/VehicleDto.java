package com.sunbeam.dto;

import com.sunbeam.entities.Company;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter

public class VehicleDto {
	private String Vname;
	private Company company;
	private String Vnumber;
	private String Vtype;
	private Long userId;
	

}

