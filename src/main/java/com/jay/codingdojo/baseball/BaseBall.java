package com.jay.codingdojo.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseBall {

	private final int randomNumber;
	private final RandomNumberService service;

	BaseBall(RandomNumberService service) {
		this.service = service;
		this.randomNumber = service.generateRandomNumber();
	}

	public static BaseBall startBaseBallGame() {
		return new BaseBall(new RandomNumberServiceImpl());
	}


	public BallCount countBall(int userInput) {

		BallCount ballCount = new BallCount();
		List<String> userInputDigits = convertIntToStringList(userInput);
		List<String> randomNumberDigits = convertIntToStringList(randomNumber);

		userInputDigits.stream()
			.forEach(digit -> {
				if (randomNumberDigits.indexOf(digit) == userInputDigits.indexOf(digit)) {
					ballCount.countStrike();

				} else if(randomNumberDigits.contains(digit)){
					ballCount.countBall();
				}
			});

		return ballCount;
	}

	private List<String> convertIntToStringList(int userInput) {
		List<String> list = new ArrayList<>();

		while (userInput > 0) {
			list.add(0, String.valueOf(userInput % 10));
			userInput /= 10;
		}

		return list;
	}

}
