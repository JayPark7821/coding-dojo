package com.jay.codingdojo.atdd.carracing.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarRacingService {

	public RaceStatusResponse create() {
		throw new UnsupportedOperationException("com.jay.codingdojo.atdd.carracing.service.CarRacingService.create()");
	}

	public RaceStatusResponse addCars(Long raceId, String carNames) {
		throw new UnsupportedOperationException("com.jay.codingdojo.atdd.carracing.service.CarRacingService.addCars()");
	}

	public RaceStatusResponse startRace(long raceId) {
		throw new UnsupportedOperationException("com.jay.codingdojo.atdd.carracing.service.CarRacingService.startRace()");
	}
}
