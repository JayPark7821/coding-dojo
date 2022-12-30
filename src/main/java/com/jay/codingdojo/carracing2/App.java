package com.jay.codingdojo.carracing2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		UserInput userInput = inputView.getUserInput();
		ResultView resultView = new ResultView();

		List<Car> cars = Arrays.stream(userInput.getCarName().split(","))
			.map(Car::new)
			.collect(Collectors.toList());

		CarRacing carRacing = new CarRacing(cars, userInput.getTryCount());
		while(!carRacing.isFinished()) {
			carRacing.countLaps();
			resultView.printCurrentPositions(carRacing.getCars());
		}
		resultView.printWinner(carRacing.getCars());
	}
}
