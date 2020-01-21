package com.digitalized.springboot.crud.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalized.springboot.crud.dto.CourseDTO;
import com.digitalized.springboot.crud.entity.Course;

public class CourseMapper {

	public static CourseDTO toDTO(Course entity) {
		return CourseDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.maxCapacity(entity.getMaxCapacity())
				.build();
	}
	
	public static List<CourseDTO> toDTOs(List<Course> entities) {
		return entities.stream().map(CourseMapper::toDTO).collect(Collectors.toList());
	}
	
	public static Course toEntity(CourseDTO dto) {
		return Course.builder()
				.id(dto.getId())
				.name(dto.getName())
				.maxCapacity(dto.getMaxCapacity())
				.build();
	}
	
	public static List<Course> toEntities(List<CourseDTO> dtos) {
		return dtos.stream().map(CourseMapper::toEntity).collect(Collectors.toList());
	}
	
}
