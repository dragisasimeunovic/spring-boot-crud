package com.digitalized.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalized.springboot.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
