package com.jay.codingdojo.carracing2;

import java.util.List;

public class CarRacing {

	private final List<Car> cars;
	private final int laps;

	public CarRacing(List<Car> cars, int laps) {
		this.cars = cars;
		this.laps = laps;
	}

	public int generateRandomNumber() {
		return (int) (Math.random() * 10);
	}
}
