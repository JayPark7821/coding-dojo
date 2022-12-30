package com.jay.codingdojo.carracing;

import java.util.stream.IntStream;

public class App {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		UserInput userInput = inputView.getUserInput();
		ResultView resultView = new ResultView();

		CarRacing carRacing = new CarRacing(userInput.getCarName());
		IntStream.range(0, userInput.getTryCount()).forEach(i -> {
			carRacing.moveCars();
			resultView.printResult(carRacing.getCurrentPositionOfAllCars());
		});

		System.out.println(carRacing.getWinner());
	}

}

