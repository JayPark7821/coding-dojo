package com.jay.codingdojo.rentacar;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class RentACar {

	private List<Car> cars = new ArrayList<>();

	public void addCar(Car car) {
		cars.add(car);
	}

	public double getRequiredFuel(String name, double distance) {
		Car selectedCar = cars.stream()
			.filter(car -> car.getName().equals(name))
			.findFirst().orElseThrow();

		return distance / selectedCar.getDistancePerLiter();
	}
}
