package com.digitalized.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalized.springboot.crud.dto.EmployeeDTO;
import com.digitalized.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/employees")
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		
		employeeDTO.setId(0);
		
		return employeeService.save(employeeDTO);
	}

	@GetMapping("/employees")
	public List<EmployeeDTO> findAllEmployees() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public EmployeeDTO getEmployee(@PathVariable int id) {
		return employeeService.findById(id);
	}
	
	@PutMapping("/employees")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		
		return employeeService.save(employeeDTO);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteById(id);
		return "Employee with id: " + id + " successfully deleted!";
	}
	
}
