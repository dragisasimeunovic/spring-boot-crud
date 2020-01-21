package com.digitalized.springboot.crud.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalized.springboot.crud.dto.CarDTO;
import com.digitalized.springboot.crud.entity.Car;

public class CarMapper {

	public static CarDTO toDTO(Car entity) {
		return CarDTO.builder()
				.id(entity.getId())
				.brand(entity.getBrand())
				.model(entity.getModel())
				.carBody(entity.getCarBody())
				.carDetails(entity.getCarDetails() != null ? CarDetailsMapper.toDTO(entity.getCarDetails()) : null)
				.build();
	}
	
	public static List<CarDTO> toDTOs(List<Car> entities) {
		return entities.stream().map(CarMapper::toDTO).collect(Collectors.toList());
	}
	
	public static Car toEntity(CarDTO dto) {
		return Car.builder()
				.id(dto.getId())
				.brand(dto.getBrand())
				.model(dto.getModel())
				.carBody(dto.getCarBody())
				.carDetails(dto.getCarDetails() != null ? CarDetailsMapper.toEntity(dto.getCarDetails()) : null)
				.build();
				
	}
	
	public static List<Car> toEntities(List<CarDTO> dtos) {
		return dtos.stream().map(CarMapper::toEntity).collect(Collectors.toList());
	}
}
