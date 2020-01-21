package com.digitalized.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalized.springboot.crud.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
