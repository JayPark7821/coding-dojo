package com.jay.codingdojo.carracing2;

import java.util.List;

public class CarRacing {

	private final List<Car> cars;
	private final int lapsTotal;
	private int lapsCompleted;

	public CarRacing(List<Car> cars, int lapsTotal) {
		this.cars = cars;
		this.lapsTotal = lapsTotal;
		this.lapsCompleted = 0;
	}

	public int generateRandomNumber() {
		return (int) (Math.random() * 10);
	}

	public void countLaps() {
		lapsCompleted++;
	}

	public boolean isFinished() {
		return lapsCompleted == lapsTotal;
	}
}
