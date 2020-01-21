package com.digitalized.springboot.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@Builder
public class CarDTO {

private int id;
	
	private String brand;
	
	private String model;
	
	private String carBody;
	
	private CarDetailsDTO carDetails;
	
}
