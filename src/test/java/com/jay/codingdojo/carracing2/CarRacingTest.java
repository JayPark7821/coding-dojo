package com.jay.codingdojo.carracing2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

	private CarRacing sut;
	private final List<Car> cars = CarFixture.createCars();

	@BeforeEach
	void setUp() {
		sut = new CarRacing(cars, 3);
	}

	@Test
	void carRacingCanGenerateRandomNumber () throws Exception {
		int randomNumber = sut.generateRandomNumber();
		assertTrue(randomNumber >= 0 && randomNumber <= 9);
	}

	@Test
	void carRacingCanCountLapsTilEnd() throws Exception {
		assertFalse(sut.isFinished());
		sut.countLaps();
		assertFalse(sut.isFinished());
		sut.countLaps();
		assertFalse(sut.isFinished());
		sut.countLaps();
		assertTrue(sut.isFinished());
	}

}
