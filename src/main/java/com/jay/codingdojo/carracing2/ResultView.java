package com.jay.codingdojo.carracing2;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

	public String printCurrentPositions(List<Car> cars) {
		String currentPosition = cars.stream()
			.map(car -> car.getName() + " : " + "-".repeat(car.getCurrentPosition()))
			.collect(Collectors.joining("\n"));
		System.out.println(currentPosition);
		System.out.println();
		return currentPosition;
	}

	public String printWinner(List<Car> cars) {
		int winningPosition = cars.stream().mapToInt(Car::getCurrentPosition).max().getAsInt();
		String winner = cars.stream()
			.filter(car -> car.getCurrentPosition() == winningPosition)
			.map(Car::getName)
			.collect(Collectors.joining(","));
		System.out.println(winner + "가 최종 우승했습니다.");
		return winner;

	}
}
