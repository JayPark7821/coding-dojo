package com.jay.codingdojo.carracing2;

public class Car {

	private final String name;
	private int position;

	public Car(String carName) {
		validateCarName(carName);
		this.name = carName;
		this.position = 0;
	}

	private void validateCarName(String name) {
		if (name.length() == 0 || name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 0~5자만 허용 합니다.");
		}
	}

	public void move(int randomNumber) {
		if(randomNumber >= 4) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getCurrentPosition() {
		return position;
	}
}
