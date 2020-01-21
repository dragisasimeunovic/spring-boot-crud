package com.digitalized.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalized.springboot.crud.entity.CarDetails;

public interface CarDetailsRepository extends JpaRepository<CarDetails, Integer> {

}
