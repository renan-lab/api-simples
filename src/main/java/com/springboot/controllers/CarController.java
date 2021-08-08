package com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dtos.CarResponseDTO;
import com.springboot.entities.Car;
import com.springboot.forms.CarForm;
import com.springboot.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	private CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public CarResponseDTO create(@RequestBody CarForm createCarForm) {
		
		Car car = new Car();
		
		car.setModel(createCarForm.getModel());
		car.setBrand(createCarForm.getBrand());
		car.setLicensePlate(createCarForm.getLicensePlate());
		
		Car carCreated = carService.create(car);
		
		return new CarResponseDTO(carCreated.getId(), carCreated.getModel(), carCreated.getBrand(), carCreated.getLicensePlate());
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		carService.delete(id);
	}
	
	@PostMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody CarForm updateCarForm) {
		carService.update(id, updateCarForm);
	}
	
	@GetMapping("/list-all")
	public List<Car> listAll() {
		return carService.listAll();
	}
	
}