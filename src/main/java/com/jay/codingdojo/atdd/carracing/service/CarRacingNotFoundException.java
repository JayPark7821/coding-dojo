package com.jay.codingdojo.atdd.carracing.service;

public class CarRacingNotFoundException extends RuntimeException {
	public CarRacingNotFoundException(Long raceId) {
		super("Car Racing not found: " + raceId);
	}
}
