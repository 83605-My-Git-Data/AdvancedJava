package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
 
public class User {
	
//	 Uid (unique identifier for each User)
//	 2) Uname (Cannot be Blank)
//	 3) Email (Cannot be Blank)
//	 4) Password (Cannot be blank, min 6 characters)
//	 5) City (Cannot be Blank)
//	 6) Contact_No (Cannot be blank, min 10 digit)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	private String name;
	private String email;
	private String password;
	private String city;
	private String contactNo;
	
	
	

}
