package com.jay.codingdojo.atdd.carracing.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.codingdojo.atdd.carracing.service.CarRacingService;
import com.jay.codingdojo.atdd.carracing.service.RaceStatusResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jay/car-racing")
public class CarRacingController {

	private final CarRacingService carRacingService;

	@PostMapping
	RaceStatusResponse create() {
		return carRacingService.create();
	}

	@PostMapping("/{raceId}/car")
	RaceStatusResponse addCars(@PathVariable("raceId") final Long raceId, String carNames) {
		return carRacingService.addCars(raceId, carNames);
	}

	@PutMapping("/{raceId}/start")
	RaceStatusResponse startRace(@PathVariable("raceId") final Long raceId) {
		return carRacingService.startRace(raceId);
	}

	@GetMapping("/{raceId}/winner")
	RaceStatusResponse getRaceWinner(@PathVariable("raceId") final Long raceId) {
		return carRacingService.getRaceWinner(1L);
	}

	@GetMapping("/{raceId}/history")
	RaceStatusResponse getRaceHistory(@PathVariable("raceId") final Long raceId) {
		throw new UnsupportedOperationException("unimplemented");
	}
}
