package com.jay.codingdojo.carracing2;

public class Car {

	private final String name;
	private int position;

	public Car(String carName) {
		this.name = carName;
		this.position = 0;
	}

	public void move() {
		position++;
	}

	public int getCurrentPosition() {
		return position;
	}
}
