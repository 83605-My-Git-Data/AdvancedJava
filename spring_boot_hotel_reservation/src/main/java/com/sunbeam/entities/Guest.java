package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "guest")
public class Guest extends BaseEntity {
	
	@Column(name = "first_name",length = 20)
	private String firstName;
	
	@Column(name = "last_name",length = 20)
	private String lastName;
	
	@Column(name = "date_of_birth")
	private LocalDate dob;
	

}
