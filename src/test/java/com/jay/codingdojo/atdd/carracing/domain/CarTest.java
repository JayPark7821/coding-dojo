package com.jay.codingdojo.atdd.carracing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void canCreateCars() throws Exception {

		CarRacing carRacing = new CarRacing();

		final List<Car> car = Car.createCars("car1,car2", carRacing);

		assertThat(car.stream().map(Car::getName).toList()).isEqualTo(List.of("car1", "car2"));
	}
}