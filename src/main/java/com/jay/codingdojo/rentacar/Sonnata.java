package com.jay.codingdojo.rentacar;

public class Sonnata extends Car {

	private final Double distancePerLiter = 10.0;

	@Override
	double getDistancePerLiter() {
		return this.distancePerLiter;
	}

}
