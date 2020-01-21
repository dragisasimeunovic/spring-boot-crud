package com.digitalized.springboot.crud.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalized.springboot.crud.dto.StudentDTO;
import com.digitalized.springboot.crud.entity.Student;

public class StudentMapper {

	public static StudentDTO toDTO(Student entity) {
		return StudentDTO.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.gpa(entity.getGpa())
				.build();
	}
	
	public static List<StudentDTO> toDTOs(List<Student> entities) {
		return entities.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
	}
	
	public static Student toEntity(StudentDTO dto) {
		return Student.builder()
				.id(dto.getId())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.gpa(dto.getGpa())
				.build();
	}
	
	public static List<Student> toEntities(List<StudentDTO> dtos) {
		return dtos.stream().map(StudentMapper::toEntity).collect(Collectors.toList());
	}
	
}
