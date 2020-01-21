package com.digitalized.springboot.crud.mapper;

import com.digitalized.springboot.crud.dto.CarDetailsDTO;
import com.digitalized.springboot.crud.entity.CarDetails;

public class CarDetailsMapper {

	public static CarDetailsDTO toDTO(CarDetails entity) {
		return CarDetailsDTO.builder()
				.id(entity.getId())
				.sensors(entity.isSensors())
				.color(entity.getColor())
				.build();
	}
	
	public static CarDetails toEntity(CarDetailsDTO dto) {
		return CarDetails.builder()
				.id(dto.getId())
				.sensors(dto.isSensors())
				.color(dto.getColor())
				.build();
	}
	
}
