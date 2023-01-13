package com.jay.codingdojo.rentacar;

import lombok.Getter;

@Getter
public abstract class Car {

	abstract double getDistancePerLiter();

	double getRequiredFuel(double distance) {
		return distance / getDistancePerLiter();
	}
}
