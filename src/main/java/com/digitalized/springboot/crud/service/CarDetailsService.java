package com.digitalized.springboot.crud.service;

import com.digitalized.springboot.crud.dto.CarDetailsDTO;

public interface CarDetailsService {

	CarDetailsDTO findById(int id);
	
	void deleteById(int id);
	
}
