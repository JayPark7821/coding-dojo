package com.jay.codingdojo.rentacar;

public class Avante extends Car {

	private final Double distancePerLiter = 15.0;

	@Override
	double getDistancePerLiter() {
		return this.distancePerLiter;
	}

}
