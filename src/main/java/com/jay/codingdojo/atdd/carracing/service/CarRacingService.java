package com.jay.codingdojo.atdd.carracing.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacing;
import com.jay.codingdojo.atdd.carracing.domain.CarRacingRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CarRacingService {

	private final CarRacingRepository repository;

	public RaceStatusResponse create() {
		final CarRacing savedCarRacing = repository.save(new CarRacing());
		return new RaceStatusResponse(savedCarRacing.getId(), null, null, null);
	}

	public RaceStatusResponse addCars(Long raceId, List<Car> cars) {
		CarRacing carRacing = repository.findById(raceId)
			.orElseThrow(() -> new CarRacingNotFoundException(raceId));
		cars.forEach(carRacing::addCar);

		return new RaceStatusResponse(raceId, null, null, String.format("%s Cars Participated", cars.size()));
	}

	public RaceStatusResponse startRace(Long raceId) {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.carracing.service.CarRacingService.startRace()");
	}

	public RaceStatusResponse getRaceWinner(Long raceId) {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.carracing.service.CarRacingService.getRaceWinner()");
	}

	public RaceStatusResponse getRaceHistory(Long raceId) {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.carracing.service.CarRacingService.getRaceHistory()");
	}

	public CarRacing findById(Long raceId) {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.carracing.service.CarRacingService.findById()");
	}
}
