package com.jay.codingdojo.carracing2;

import java.util.List;

public class CarFixture {

	public static List<Car> createCars() {
		return List.of(new Car("test1"), new Car("test2"), new Car("test3"));

	}
}
