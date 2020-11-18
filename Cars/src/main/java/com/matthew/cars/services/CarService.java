package com.matthew.cars.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.cars.models.Car;
import com.matthew.cars.repositories.CarRepository;

@Service
public class CarService {
	// Dependency Injection
	private CarRepository cRepo;
	
	public CarService(CarRepository repo) {
		this.cRepo = repo;
	}
	
	// Get All Cars
	public List<Car> getAllCars(){
		return this.cRepo.findAll();
	}
	
	// Get One Car
	public Car getSingleCar(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	// Create A Car
	public Car createCar(Car newCar) {
		return this.cRepo.save(newCar);
	}
	
	// Delete A Car
	public void deleteCar(Long id) {
		this.cRepo.deleteById(id);
	}
	
	// Update a Car
	public Car updateCar(Car car) {
		return this.cRepo.save(car);
	}
}
