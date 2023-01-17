package com.jay.codingdojo.atdd.carracing.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacing;
import com.jay.codingdojo.atdd.carracing.domain.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {

	private final CarRepository repository;

	List<Car> create(String names, CarRacing carRacing) {
		Assert.notNull(carRacing, "carRacing must not be null");
		List<Car> cars = Car.createCars(names, carRacing);
		return repository.saveAll(cars);
	}
}
