package com.digitalized.springboot.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalized.springboot.crud.dto.CarDTO;
import com.digitalized.springboot.crud.entity.Car;
import com.digitalized.springboot.crud.exception.EmployeeException;
import com.digitalized.springboot.crud.mapper.CarMapper;
import com.digitalized.springboot.crud.repository.CarRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;
	
	@Autowired
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Override
	public CarDTO findById(int id) {
		Optional<Car> car = carRepository.findById(id);
		
		if (!car.isPresent()) {
			throw new EmployeeException("'car' entity with id: " + id + " not found!");
		}
		
		return CarMapper.toDTO(car.get());
	}
	
	@Override
	public CarDTO save(CarDTO carDTO) {
		Car car = CarMapper.toEntity(carDTO);
		if (car.getCarDetails() != null) {
			car.getCarDetails().setCar(car);
		}
		carRepository.save(car);
		return CarMapper.toDTO(car);
	}

	
	
}
