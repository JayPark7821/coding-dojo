package com.jay.codingdojo.atdd.carracing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {

	private final CarRepository repository;

	//TODO implement
	List<Car> create(String name) {
		throw new UnsupportedOperationException();
	}
}
