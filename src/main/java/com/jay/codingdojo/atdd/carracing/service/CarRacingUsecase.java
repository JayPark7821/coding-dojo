package com.jay.codingdojo.atdd.carracing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.carracing.domain.Car;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarRacingUsecase {

	private final CarRacingService carRacingService;
	private final CarService carService;

	public RaceStatusResponse addCars(Long raceId, String names) {
		List<String> carNameList = List.of(names.split(","));

		List<Car> addedCarIds = carNameList.stream()
			.map(carService::create)
			.toList();

		return carRacingService.addCars(raceId, addedCarIds);
	}
}
