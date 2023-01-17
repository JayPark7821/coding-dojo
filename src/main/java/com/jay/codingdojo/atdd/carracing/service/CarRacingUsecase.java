package com.jay.codingdojo.atdd.carracing.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarRacingUsecase {

	private final CarRacingService carRacingService;
	private final CarService carService;

	// TODO implement
	public RaceStatusResponse addCars(Long raceId, String names) {

		throw new UnsupportedOperationException();
		// List<String> carNameList = List.of(names.split(","));
		//
		// List<Car> addedCarIds = carNameList.stream()
		// 	.map(carService::create)
		// 	.toList();
		//
		// return carRacingService.addCars(raceId, addedCarIds);
	}
}
