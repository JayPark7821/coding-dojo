package com.jay.codingdojo.baseball;

import java.util.Random;

public class BaseBall {

	private final int randomNumber;

	private BaseBall() {
		this.randomNumber = generateRandomNumber();
	}

	public static BaseBall startBaseBallGame() {
		return new BaseBall();
	}

	int generateRandomNumber() {
		 Random random = new Random();
		 return random.nextInt(900) + 100;
	}

}
