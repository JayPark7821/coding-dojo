package com.jay.codingdojo.atdd.carracing.service;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {

	private final CarRepository repository;

	public CarResponse create(String name) {

		final Car savedCar = repository.save(new Car(name));
		return new CarResponse(savedCar.getId(), savedCar.getName());
	}
}
