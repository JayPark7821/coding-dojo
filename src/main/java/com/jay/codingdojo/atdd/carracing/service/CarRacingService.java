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

	public RaceStatusResponse startRace(Long raceId) {
		throw new UnsupportedOperationException("com.jay.codingdojo.atdd.carracing.service.CarRacingService.startRace()");
	}

	public RaceStatusResponse getRaceWinner(Long raceId) {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.carracing.service.CarRacingService.getRaceWinner()");
	}

	public RaceStatusResponse getRaceHistory(Long raceId) {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.carracing.service.CarRacingService.getRaceHistory()");
	}
}
