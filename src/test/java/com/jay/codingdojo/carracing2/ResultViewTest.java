package com.jay.codingdojo.carracing2;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

	private ResultView sut;
	private final List<Car> cars = CarFixture.createCars();
	private final CarRacing carRacing = new CarRacing(cars, 3);

	@BeforeEach
	void setUp() {
		sut = new ResultView();
	}

	@Test
	void resultViewCanPrintCurrentPositionsOfAllCars() throws Exception {
		String currentPositions = sut.printCurrentPositions(cars);
		Assertions.assertThat(currentPositions)
			.contains(
				cars.stream()
					.map(car-> car.getName() + " : ")
					.collect(Collectors.toList())
			);
	}

}
