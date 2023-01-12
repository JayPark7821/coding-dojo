package com.jay.codingdojo.atdd.carracing.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarRacing {

	private Long id;

	private List<Car> cars = new ArrayList<>();

	public CarRacing(Long id) {
		this.id = id;
	}

	public void addCar(Car car) {
		cars.add(car);
	}
}
