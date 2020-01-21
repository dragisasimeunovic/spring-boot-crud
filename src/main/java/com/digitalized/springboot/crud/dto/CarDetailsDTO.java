package com.digitalized.springboot.crud.dto;

import com.digitalized.springboot.crud.entity.Car;

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
public class CarDetailsDTO {

	private int id;
	
	private boolean sensors;
	
	private String color;
	
}
