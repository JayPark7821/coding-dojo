package com.jay.codingdojo.atdd.carracing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacing;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarRacingUsecase {

	private final CarRacingService carRacingService;
	private final CarService carService;

	// TODO implement
	public RaceStatusResponse addCars(Long raceId, String names) {
		CarRacing carRacing = carRacingService.findById(raceId);
		List<Car> cars = carService.create(names, carRacing);
		return carRacingService.addCars(carRacing, cars);
	}
}
