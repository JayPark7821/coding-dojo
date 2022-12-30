package com.jay.codingdojo.carracing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

	private final List<Car> cars;

	public CarRacing(String... carNames) {
		this.cars = Arrays.stream(carNames)
				.map(Car::new)
				.collect(Collectors.toList());
	}

	public int generateRandomNumber() {
		return (int) (Math.random() * 10);
	}
}
