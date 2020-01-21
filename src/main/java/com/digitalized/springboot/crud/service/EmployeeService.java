package com.digitalized.springboot.crud.service;

import java.util.List;

import com.digitalized.springboot.crud.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO save(EmployeeDTO employeeDTO);
	
	List<EmployeeDTO> findAll();

	EmployeeDTO findById(int id);

	void deleteById(int id);
}
