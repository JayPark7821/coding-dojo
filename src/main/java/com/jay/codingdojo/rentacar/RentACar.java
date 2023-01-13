package com.jay.codingdojo.rentacar;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class RentACar {

	private List<Car> cars = new ArrayList<>();

	public void addCar(Car car) {
		throw new UnsupportedOperationException("com.jay.codingdojo.rentacar.RentACar.addCar())");
	}
}
