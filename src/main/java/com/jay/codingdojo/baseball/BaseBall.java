package com.jay.codingdojo.baseball;

import java.util.regex.Pattern;

public class BaseBall {
	public static final Pattern pattern = Pattern.compile("^[1-9]{3}$");
	private final BallCount ballCount;

	BaseBall(RandomNumberService service) {
		this.ballCount = new BallCount(service.generateRandomNumber());
	}

	public static BaseBall startBaseBallGame() {
		return new BaseBall(new RandomNumberServiceImpl());
	}

	public BallCount countBall(String userInput) {
		validateUserInput(userInput);
		return this.ballCount.countBall(userInput);
	}

	private static void validateUserInput(String userInput) {
		if(!pattern.matcher(userInput).matches()) {
			throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
		}
	}

}
