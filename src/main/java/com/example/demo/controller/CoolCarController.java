package com.example.demo.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.model.CarRepository;


// @RestController
public class CoolCarController {
	private CarRepository repository;
	
	
	public CoolCarController(CarRepository repo) {
		this.repository = repo;
	}
	
	// @GetMapping("/cool-cars")
	// @CrossOrigin(origins="http://localhost:4200")
	public Collection<Car> coolCars() {
		return repository.findAll().stream()
				.filter(this::isCool)
				.collect(Collectors.toList());
	}
	
	private boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") &&
				!car.getName().equals("Trimnph Stag") &&
				!car.getName().equals("Ford Pinto") &&
				!car.getName().equals("Yugo GV") ;
	}
}
