package com.jay.codingdojo.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BaseBall {

	private final List<String> randomNumber;
	private final RandomNumberService service;

	private static final Pattern pattern = Pattern.compile("^[0-9]{3}$");

	BaseBall(RandomNumberService service) {
		this.service = service;
		this.randomNumber = convertIntToStringList(service.generateRandomNumber());
	}

	public static BaseBall startBaseBallGame() {
		return new BaseBall(new RandomNumberServiceImpl());
	}

	public BallCount countBall(String userInput) {
		validateUserInput(userInput);
		return createAndCountBalls(userInput);
	}

	private BallCount createAndCountBalls(String userInput) {

		BallCount ballCount = new BallCount();
		List<String> userInputDigits = convertIntToStringList(userInput);

		userInputDigits.stream()
			.forEach(digit -> {
				if (isStrike(userInputDigits, digit)) {
					ballCount.countStrike();

				} else if(randomNumber.contains(digit)){
					ballCount.countBall();
				}
			});

		return ballCount;
	}

	private boolean isStrike(List<String> userInputDigits, String digit) {
		return randomNumber.indexOf(digit) == userInputDigits.indexOf(digit);
	}

	private void validateUserInput(String userInput) {

		if(!pattern.matcher(userInput).matches()) {
			throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
		}
	}

	private List<String> convertIntToStringList(String number) {
		return Arrays.asList(number.split(""));
	}

}
