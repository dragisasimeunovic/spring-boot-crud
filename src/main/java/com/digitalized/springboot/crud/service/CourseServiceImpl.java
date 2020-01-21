package com.digitalized.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalized.springboot.crud.dto.CourseDTO;
import com.digitalized.springboot.crud.entity.Course;
import com.digitalized.springboot.crud.exception.EmployeeException;
import com.digitalized.springboot.crud.mapper.CourseMapper;
import com.digitalized.springboot.crud.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@Override
	public CourseDTO save(CourseDTO courseDTO) {
		Course course = CourseMapper.toEntity(courseDTO);
		courseRepository.save(course);
		return CourseMapper.toDTO(course);
	}

	@Override
	public List<CourseDTO> findAll() {
		return CourseMapper.toDTOs(courseRepository.findAll());
	}

	@Override
	public CourseDTO findById(int id) {

		Optional<Course> course = courseRepository.findById(id);
		if (!course.isPresent()) {
			throw new EmployeeException("'course' entity with id: " + id + " not found!");
		}
		
		return CourseMapper.toDTO(course.get());
	}

	@Override
	public void deleteById(int id) {
		
		Optional<Course> course = courseRepository.findById(id);
		if (!course.isPresent()) {
			throw new EmployeeException("'course' entity with id: " + id + " not found!");
		}
		
		courseRepository.deleteById(id);
	}

}
