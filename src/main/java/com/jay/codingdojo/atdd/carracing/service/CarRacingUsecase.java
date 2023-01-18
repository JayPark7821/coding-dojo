package com.jay.codingdojo.atdd.carracing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacing;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarRacingUsecase {

	private final CarRacingService carRacingService;
	private final CarService carService;

	@Transactional
	public RaceStatusResponse addCars(Long raceId, String names) {
		CarRacing carRacing = carRacingService.findById(raceId);
		List<Car> cars = carService.create(names, carRacing);
		return new RaceStatusResponse(carRacing.getId(), null, null,
			String.format("%s Cars Participated", cars.size()));
	}
}
