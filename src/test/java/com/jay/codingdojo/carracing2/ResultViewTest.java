package com.jay.codingdojo.carracing2;

import static org.assertj.core.api.Assertions.*;

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
		assertThat(currentPositions)
			.contains(
				cars.stream()
					.map(car-> car.getName() + " : ")
					.collect(Collectors.toList())
			);
	}

	@Test
	void resultViewCanPrintWinnter() throws Exception {
		Car winner = cars.get(0);
		winner.move(5);

		String winners = sut.printWinner(cars);

		assertThat(winners)
			.contains(winner.getName());

	}

}
