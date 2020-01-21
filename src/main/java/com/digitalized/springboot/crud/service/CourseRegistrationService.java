package com.digitalized.springboot.crud.service;

import java.util.List;

import com.digitalized.springboot.crud.dto.StudentDTO;
import com.digitalized.springboot.crud.entity.CourseRegistration;

public interface CourseRegistrationService {

	 CourseRegistration save(int studentId, int courseId);
	 
	 List<StudentDTO> findAllStudentsOnCourseByCourseId(int courseId);
	
}
