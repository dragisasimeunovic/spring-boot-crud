package com.digitalized.springboot.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalized.springboot.crud.dto.CarDTO;
import com.digitalized.springboot.crud.service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {

	private CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@PostMapping("/cars")
	public CarDTO addCar(@RequestBody CarDTO car) {
		return carService.save(car);
	}
	
	@DeleteMapping("/cardetails/{id}")
	public void deleteCarDetails(@PathVariable int id) {
		// Finish it
	}
	
}
