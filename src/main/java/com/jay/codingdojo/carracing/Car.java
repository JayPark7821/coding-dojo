package com.jay.codingdojo.carracing;

public class Car {

	private final String name;
	private int position;

	public Car(String name) {

		validateCarName(name);

		this.name = name;
		this.position = 0;
	}

	private void validateCarName(String name) {
		if (name.length() == 0 || name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 0~5자만 허용 합니다.");
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void move() {
		this.position++;
	}

	public String showPosition() {
		return name + " : " + "-".repeat(position);
	}
}
