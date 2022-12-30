package com.jay.codingdojo.carracing2;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
	public String printCurrentPositions(List<Car> cars) {
		String currentPosition = cars.stream()
			.map(car -> car.getName() + " : " + "-".repeat(car.getCurrentPosition()))
			.collect(Collectors.joining("\n"));
		System.out.println(currentPosition);
		return currentPosition;
	}
}
