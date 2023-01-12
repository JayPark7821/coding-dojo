package com.jay.codingdojo.atdd.carracing.service;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {

	private final CarRepository repository;

	Car create(String name) {
		return repository.save(new Car(name));
	}
}
