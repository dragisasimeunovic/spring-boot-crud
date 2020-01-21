package com.digitalized.springboot.crud.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.digitalized.springboot.crud.dto.EmployeeDTO;
import com.digitalized.springboot.crud.entity.Employee;

public class EmployeeMapper {

	public static Employee toEntity(EmployeeDTO dto) {
		return Employee.builder()
				.id(dto.getId())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.email(dto.getEmail())
				.build();
	}
	
	public static List<Employee> toEntities(List<EmployeeDTO> dtos) {
		if (dtos == null || dtos.isEmpty()) {
			return new ArrayList<>();
		}
		return dtos.stream().map(EmployeeMapper::toEntity).collect(Collectors.toList());
		//return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}
	
	public static EmployeeDTO toDTO(Employee entity) {
		return EmployeeDTO.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.build();
	}
	
	public static List<EmployeeDTO> toDTOs(List<Employee> entities) {
		if (entities == null || entities.isEmpty()) {
			return new ArrayList<>();
		}
		return entities.stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
	}
	
}
