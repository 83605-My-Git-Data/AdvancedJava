package com.sunbeam.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.sunbeam.entities.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CourseDto {
	
	@NotBlank(message = "name should not be empty")
	private String name;
	
	@NotNull
	private Category category;
	
	@NotNull
	private LocalDate startDate;
	
	@NotNull
	private LocalDate endDate;
	
	@NotNull
	private double fees;
	
	@NotBlank
	private String gradeToPass;

}
