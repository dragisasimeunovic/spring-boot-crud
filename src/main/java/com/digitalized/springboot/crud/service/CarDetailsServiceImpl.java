package com.digitalized.springboot.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalized.springboot.crud.dto.CarDetailsDTO;
import com.digitalized.springboot.crud.entity.CarDetails;
import com.digitalized.springboot.crud.exception.EmployeeException;
import com.digitalized.springboot.crud.mapper.CarDetailsMapper;
import com.digitalized.springboot.crud.repository.CarDetailsRepository;

@Service
@Transactional
public class CarDetailsServiceImpl implements CarDetailsService {

	private CarDetailsRepository carDetailsRepository;
	
	@Autowired
	public CarDetailsServiceImpl(CarDetailsRepository carDetailsRepository) {
		this.carDetailsRepository = carDetailsRepository;
	}
	
	@Override
	public CarDetailsDTO findById(int id) {
		Optional<CarDetails> carDetails = carDetailsRepository.findById(id);
		
		if (!carDetails.isPresent()) {
			throw new EmployeeException("'car_details' entity with id: " + id + " not found!");
		}
		
		return CarDetailsMapper.toDTO(carDetails.get());
	}
	
	@Override
	public void deleteById(int id) {
		Optional<CarDetails> carDetails = carDetailsRepository.findById(id);
		
		if (!carDetails.isPresent()) {
			throw new EmployeeException("'car_details' entity with id: " + id + " not found!");
		}
		
		carDetailsRepository.deleteById(id);
	}

	
	
}
