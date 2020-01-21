package com.digitalized.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalized.springboot.crud.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
