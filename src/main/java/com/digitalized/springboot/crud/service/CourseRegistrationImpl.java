package com.digitalized.springboot.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalized.springboot.crud.dto.CourseDTO;
import com.digitalized.springboot.crud.dto.StudentDTO;
import com.digitalized.springboot.crud.entity.Course;
import com.digitalized.springboot.crud.entity.CourseRegistration;
import com.digitalized.springboot.crud.entity.Student;
import com.digitalized.springboot.crud.mapper.CourseMapper;
import com.digitalized.springboot.crud.mapper.StudentMapper;
import com.digitalized.springboot.crud.repository.CourseRegistrationRepository;

@Service
@Transactional
public class CourseRegistrationImpl implements CourseRegistrationService {

	private CourseRegistrationRepository courseRegistrationRepository;
	
	private StudentService studentService;
	
	private CourseService courseService;
	
	@Autowired
	public CourseRegistrationImpl(CourseRegistrationRepository courseRegistrationRepository, StudentService studentService,  CourseService courseService) {
		this.courseRegistrationRepository = courseRegistrationRepository;
		this.studentService = studentService;
		this.courseService = courseService;
	}
	
	@Override
	public CourseRegistration save(int studentId, int courseId) {
		
		Student student = StudentMapper.toEntity(studentService.findById(studentId));
		Course course = CourseMapper.toEntity(courseService.findById(courseId));
		
		CourseRegistration courseRegistration = new CourseRegistration(0, student, course);
		return courseRegistrationRepository.save(courseRegistration);
	}
	
	@Override
	public List<StudentDTO> findAllStudentsOnCourseByCourseId(int courseId) {
		
		// findById() method contains check if course is found
		courseService.findById(courseId);
		
		return StudentMapper.toDTOs(courseRegistrationRepository.findAllStudentsOnCourseByCourseId(courseId));
	}  
	
}
