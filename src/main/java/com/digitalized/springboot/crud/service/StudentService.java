package com.digitalized.springboot.crud.service;

import java.util.List;

import com.digitalized.springboot.crud.dto.StudentDTO;

public interface StudentService {

	StudentDTO save(StudentDTO studentDTO);
	
	List<StudentDTO> findAll();
	
	StudentDTO findById(int id);
	
	void deleteById(int id);
	
}
