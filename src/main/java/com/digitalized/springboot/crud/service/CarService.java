package com.digitalized.springboot.crud.service;

import com.digitalized.springboot.crud.dto.CarDTO;

public interface CarService {

	CarDTO findById(int id);
	
	CarDTO save(CarDTO carDTO);
	
}
