package com.digitalized.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalized.springboot.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
