package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter

@Table(name = "vehicle")
public class Vehicle  {
	
	
//	Id (unique identifier for each Projects, auto generated, starts from 1)
//	2) Vname (Cannot be Blank, Example: Splendor, Amaze, Pulsar, etc.)
//	3) Company (Enum, Example: Hero, Honda, Bajaj, etc.)
//	4) Vnumber (Cannot be Blank, Example: MH09AB1111, MH10CD2222, MHEF3333, etc.)
//	5) Vtype (Cannot be Blank, Example: bike, sedan, cruiser, etc.)
//	6) Uid (User ID, FK)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "vehicle_name")
	private String Vname;
	
	@Enumerated(EnumType.STRING)
	private Company company;
	
	@Column(name = "vehicle_number")
	private String Vnumber;
	
	@Column(name = "vehicle_type")
	private String Vtype;
	//many vehicle -> 1 user
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	
	
	

}
