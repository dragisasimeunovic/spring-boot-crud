package com.digitalized.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalized.springboot.crud.dto.StudentDTO;
import com.digitalized.springboot.crud.entity.Student;
import com.digitalized.springboot.crud.exception.EmployeeException;
import com.digitalized.springboot.crud.mapper.StudentMapper;
import com.digitalized.springboot.crud.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public StudentDTO save(StudentDTO studentDTO) {
		Student student = StudentMapper.toEntity(studentDTO);
		studentRepository.save(student);
		return StudentMapper.toDTO(student);
	}

	@Override
	public List<StudentDTO> findAll() {
		return StudentMapper.toDTOs(studentRepository.findAll());
	}

	@Override
	public StudentDTO findById(int id) {
		
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			throw new EmployeeException("'student' entity with id: " + id + " not found!");
		}
		
		return StudentMapper.toDTO(student.get());
	}

	@Override
	public void deleteById(int id) {
		
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			throw new EmployeeException("'student' entity with id: " + id + " not found!");
		}
		
		studentRepository.deleteById(id);
	}

	
	
}
