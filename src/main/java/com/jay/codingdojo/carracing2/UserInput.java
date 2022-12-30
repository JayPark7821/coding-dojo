package com.jay.codingdojo.carracing2;

public class UserInput {
	private String carName;
	private int tryCount;

	public UserInput(String carName, int tryCount) {
		this.carName = carName;
		this.tryCount = tryCount;
	}

	public String getCarName() {
		return carName;
	}

	public int getTryCount() {
		return tryCount;
	}
}
