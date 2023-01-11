package com.jay.codingdojo.baseball;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BallCount {

	private int balls;
	private int strikes;

	private final String randomNumber;

	public BallCount(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	public int getBalls() {
		return balls;
	}

	public int getStrikes() {
		return strikes;
	}

	public BallCount countBall(String userInput) {
		List<String> userInputDigits = Arrays.asList(userInput.split(""));

		userInputDigits
			.forEach(digit -> {
				if (isStrike(userInput, digit)) {
					this.strikes++;
				} else if (this.randomNumber.contains(digit)) {
					this.balls++;
				}
			});

		return this;
	}

	private boolean isStrike(String userInput, String digit) {
		return this.randomNumber.indexOf(digit) == userInput.indexOf(digit);
	}
}
