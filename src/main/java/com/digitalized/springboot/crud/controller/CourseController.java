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

import com.digitalized.springboot.crud.dto.CourseDTO;
import com.digitalized.springboot.crud.dto.StudentDTO;
import com.digitalized.springboot.crud.entity.CourseRegistration;
import com.digitalized.springboot.crud.service.CourseRegistrationService;
import com.digitalized.springboot.crud.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	private CourseService courseService;
	private CourseRegistrationService courseRegistrationService;
	
	@Autowired
	public CourseController(CourseService courseService, CourseRegistrationService courseRegistrationService) {
		this.courseService = courseService;
		this.courseRegistrationService = courseRegistrationService;
	}
	
	@PostMapping("/courses")
	public CourseDTO addCourse(@RequestBody CourseDTO course) {
		course.setId(0);
		return courseService.save(course);
	}
	
	@GetMapping("/courses")
	public List<CourseDTO> findAllCourses() {
		return courseService.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public CourseDTO getCourse(@PathVariable int id) {
		return courseService.findById(id);
	}
	
	@PutMapping("/courses")
	public CourseDTO updateCourse(@RequestBody CourseDTO course) {
		return courseService.save(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public String deleteCourse(@PathVariable int id) {
		courseService.deleteById(id);
		return "Course with id: " + id + " successfully deleted!";
	}
	
	@PostMapping("/courses/{courseId}/students/{studentId}")
	public CourseRegistration addStudentOnCourse(@PathVariable int courseId, @PathVariable int studentId) {
		return courseRegistrationService.save(studentId, courseId);
	}
	
	@GetMapping("/courses/{id}/students")
	public List<StudentDTO> findAllStudentsOnCourse(@PathVariable int id) {
		return courseRegistrationService.findAllStudentsOnCourseByCourseId(id);
	}
	
}
