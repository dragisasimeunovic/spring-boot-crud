package com.digitalized.springboot.crud.service;

import java.util.List;

import com.digitalized.springboot.crud.dto.CourseDTO;

public interface CourseService {

	CourseDTO save(CourseDTO courseDTO);
	
	List<CourseDTO> findAll();
	
	CourseDTO findById(int id);
	
	void deleteById(int id);
	
}
