package com.digitalized.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalized.springboot.crud.dto.EmployeeDTO;
import com.digitalized.springboot.crud.entity.Employee;
import com.digitalized.springboot.crud.exception.EmployeeException;
import com.digitalized.springboot.crud.mapper.EmployeeMapper;
import com.digitalized.springboot.crud.repository.EmployeeRepository;

@Service
// @Transactional above class is used to make every class method @Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	@Transactional
	public EmployeeDTO save(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.toEntity(employeeDTO);
		employeeRepository.save(employee);
		return EmployeeMapper.toDTO(employee);
	}

	@Override
	@Transactional
	public List<EmployeeDTO> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		return EmployeeMapper.toDTOs(employees);
	}

	@Override
	@Transactional
	public EmployeeDTO findById(int id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if (!employee.isPresent()) {
			throw new EmployeeException("'employee' entity with id: " + id + " not found!"); 
		}
	
		return EmployeeMapper.toDTO(employee.get());
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if (!employee.isPresent()) {
			throw new EmployeeException("'employee' entity with id: " + id + " not found!"); 
		}

		employeeRepository.deleteById(id);
	}
	
}
