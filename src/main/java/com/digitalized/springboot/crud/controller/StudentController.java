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

import com.digitalized.springboot.crud.dto.StudentDTO;
import com.digitalized.springboot.crud.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/students")
	public StudentDTO addStudent(@RequestBody StudentDTO student) {
		student.setId(0);
		return studentService.save(student);
	}
	
	@GetMapping("/students")
	public List<StudentDTO> findAllStudents() {
		return studentService.findAll();
	}
	
	@GetMapping("/students/{id}")
	public StudentDTO getStudent(@PathVariable int id) {
		return studentService.findById(id);
	}
	
	@PutMapping("/students")
	public StudentDTO updateStudent(@RequestBody StudentDTO student) {
		return studentService.save(student);
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteById(id);
		return "Student with id: " + id + " successfully deleted!";
	}
	
}
