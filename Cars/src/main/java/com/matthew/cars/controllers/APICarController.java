package com.matthew.cars.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matthew.cars.models.Car;
import com.matthew.cars.services.CarService;

@RestController
//localhost:8080
//localhost:8080/api
@CrossOrigin
@RequestMapping("/api")
public class APICarController {
	private CarService cService;
	
	public APICarController(CarService service) {
		this.cService = service;
	}
	
	// Routes
	@GetMapping("")
	public List<Car> index(){		
		return this.cService.getAllCars();	   
	}
	
	@RequestMapping("/{id}")
	public Car getCar(@PathVariable("id") Long id) {
		return this.cService.getSingleCar(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Car create(Car car) {
		return this.cService.createCar(car);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteCar(@PathVariable("id") Long id) {
		this.cService.deleteCar(id);
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public Car edit(@PathVariable("id") Long id, Car updatedCar) {
		return this.cService.updateCar(updatedCar);
	}
	
}
