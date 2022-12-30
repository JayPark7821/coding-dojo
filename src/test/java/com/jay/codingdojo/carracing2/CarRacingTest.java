package com.jay.codingdojo.carracing2;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CarRacingTest {

	private final List<Car> cars = List.of(new Car("test1"), new Car("test2"), new Car("test3"));

	@Test
	void canCreateCarRacing() throws Exception {
		CarRacing sut = new CarRacing(cars, 5);
	}
}
