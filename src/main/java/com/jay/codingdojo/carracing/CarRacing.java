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

	public void moveCars() {
		cars.forEach(car -> {
			if (generateRandomNumber() >= 4) {
				car.move();
			}
		});
	}

	public String getCurrentPositionOfAllCars() {
		return cars.stream()
			.map(Car::showPosition)
			.collect(Collectors.joining("\n"));
	}

	public String getWinner() {
		int maxPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
		return cars.stream()
				.filter(car -> car.getPosition() == maxPosition)
				.map(Car::getName)
				.collect(Collectors.joining(","));
	}
}
