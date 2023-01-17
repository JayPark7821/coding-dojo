package com.jay.codingdojo.atdd.carracing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void canCreateCars() throws Exception {

		final List<Car> car = Car.createCars("car1,car2", new CarRacing(1L));

		assertThat(car).isEqualTo(
			List.of(new Car(null, "car1", new CarRacing(1L)),
				new Car(null, "car2", new CarRacing(1L)))
		);
	}
}