package com.digitalized.springboot.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalized.springboot.crud.entity.CourseRegistration;
import com.digitalized.springboot.crud.entity.Student;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {
	
	@Query("select cr.student from CourseRegistration cr where cr.course.id = ?1")
	List<Student> findAllStudentsOnCourseByCourseId(int courseId);
	
}
