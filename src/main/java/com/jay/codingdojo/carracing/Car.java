package com.jay.codingdojo.carracing;

public class Car {

	private final String name;
	private int position;

	public Car(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
		}
		this.name = name;
		this.position = 0;
	}

	public void move() {
		this.position++;
	}

	public String showPosition() {
		return name + " : " + "-".repeat(position);
	}
}
