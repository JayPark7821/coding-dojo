package com.jay.codingdojo.baseball;

import java.util.ArrayList;
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

		validateUserInput(userInput);

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

	private static void validateUserInput(int userInput) {
		if(userInput < 100 || userInput > 999) {
			throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
		}
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
