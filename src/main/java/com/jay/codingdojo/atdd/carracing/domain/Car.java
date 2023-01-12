package com.jay.codingdojo.atdd.carracing.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	private Long id;
	private String name;

	public Car(String name) {
		if (name.length() > 5 || name.length() < 1) {
			throw new IllegalArgumentException("Car name must be between 1 and 5 characters");
		}
		this.name = name;
	}
}
