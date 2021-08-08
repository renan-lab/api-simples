package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Car;
import com.springboot.forms.CarForm;
import com.springboot.repositories.CarRepository;

@Service
public class CarService {

	private CarRepository carRepository;
	
	@Autowired
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
		
	public Car create(Car car) {
		return carRepository.save(car);
	}
	
	public void delete(Long id) {
		carRepository.deleteById(id);
	}
	
	public void update(Long id, CarForm updateCarForm) {
		Car car = carRepository.getById(id);
		
		car.setModel(updateCarForm.getModel());
		car.setBrand(updateCarForm.getBrand());
		car.setLicensePlate(updateCarForm.getLicensePlate());
		
		carRepository.save(car);
	}
	
	public List<Car> listAll() {
		return carRepository.findAll();
	}
	
}
