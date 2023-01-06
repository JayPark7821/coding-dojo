package com.jay.codingdojo.baseball;

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
		return new BallCount(0, 0);
	}
}
